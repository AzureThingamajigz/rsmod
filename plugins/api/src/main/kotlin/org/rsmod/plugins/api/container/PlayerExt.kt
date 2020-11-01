package org.rsmod.plugins.api.container

import org.rsmod.game.model.item.container.ItemContainer
import org.rsmod.game.model.mob.Player
import org.rsmod.game.model.ui.Component
import org.rsmod.plugins.api.protocol.packet.server.UpdateInvFull

fun Player.sendItemContainer(key: Int? = null, component: Component? = null, container: ItemContainer) {
    check(key != null || component == null) { "Container key and/or component must be set." }
    val packet = UpdateInvFull(key ?: -1, component?.packed ?: -1, container)
    write(packet)
}
