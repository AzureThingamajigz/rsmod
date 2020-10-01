package gg.rsmod.plugins.core.update.player

import com.google.inject.Inject
import gg.rsmod.game.model.domain.repo.XteaRepository
import gg.rsmod.game.model.map.MapIsolation
import gg.rsmod.game.model.map.viewport
import gg.rsmod.game.model.mob.Player
import gg.rsmod.game.model.mob.PlayerList
import gg.rsmod.game.model.mob.update.UpdateTask
import gg.rsmod.game.model.step.StepSpeed
import gg.rsmod.plugins.core.protocol.packet.server.RebuildNormal

class PlayerMovementTask @Inject constructor(
    private val playerList: PlayerList,
    private val xteasRepository: XteaRepository,
    private val mapIsolation: MapIsolation
) : UpdateTask {

    override fun execute() {
        playerList.forEach { player ->
            if (player == null) {
                return@forEach
            }
            player.pollMovement()

            val coords = player.coords
            val viewport = player.viewport
            val mapSquare = coords.mapSquare()
            val rebuild = !viewport.contains(mapSquare) || coords.plane != viewport.plane()
            if (rebuild) {
                val newViewport = coords.zone().viewport(mapIsolation)
                val rebuildNormal = RebuildNormal(
                    gpi = null,
                    playerZone = coords.zone(),
                    viewport = newViewport,
                    xteas = xteasRepository
                )
                player.write(rebuildNormal)
                player.viewport.refresh(coords.plane, newViewport)
            }
        }
    }

    private fun Player.pollMovement() {
        val walkDirection = steps.poll() ?: return
        var translateX = walkDirection.x
        var translateY = walkDirection.y
        if (speed == StepSpeed.Run) {
            val runDirection = steps.poll()
            runDirection?.let {
                translateX += it.x
                translateY += it.y
            }
        }
        coords = coords.translate(translateX, translateY)
    }
}
