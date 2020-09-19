package gg.rsmod.plugins.protocol.structure.client

import gg.rsmod.plugins.protocol.DesktopPacketStructure
import gg.rsmod.plugins.protocol.packet.client.EventAppletFocus
import gg.rsmod.plugins.protocol.packet.client.EventMouseClick
import gg.rsmod.plugins.protocol.packet.client.EventMouseMove

val desktopPackets: DesktopPacketStructure by inject()
val packets = desktopPackets.client

packets.register<EventMouseMove> {
    opcode = 23
    length = -1
    suppress = true
}

packets.register<EventMouseClick> {
    opcode = 66
    length = 6
    suppress = true
}

packets.register<EventAppletFocus> {
    opcode = 26
    length = 1
    suppress = true
}
