package org.rsmod.plugins.content.pathfinder

import org.rsmod.game.path.PathFinder
import org.rsmod.plugins.api.protocol.packet.MapMove

val pathfinder: PathFinder by inject()

onAction<MapMove> {
    val coordinates = pathfinder.findPath(
        start = player.coords,
        dest = destination,
        size = 1
    )
    player.steps.clear()
    player.steps.addAll(coordinates)
}
