package gg.rsmod.plugins.api

import gg.rsmod.game.model.map.MapSquare
import gg.rsmod.game.model.mob.Player

fun Player.refreshViewport(newViewport: List<MapSquare>) {
    viewport.clear()
    viewport.addAll(newViewport)
}
