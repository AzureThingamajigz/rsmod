package gg.rsmod.plugins.core.protocol.structure.server

import gg.rsmod.game.message.PacketLength
import gg.rsmod.plugins.core.protocol.packet.server.IfOpenSub
import gg.rsmod.plugins.core.protocol.packet.server.IfOpenTop
import gg.rsmod.plugins.core.protocol.packet.server.RunClientScript
import gg.rsmod.plugins.core.protocol.structure.DesktopPacketStructure
import io.guthix.buffer.writeByteNeg
import io.guthix.buffer.writeIntIME
import io.guthix.buffer.writeStringCP1252

val desktopPackets: DesktopPacketStructure by inject()
val packets = desktopPackets.server

packets.register<IfOpenTop> {
    opcode = 48
    write {
        it.writeShortLE(interfaceId)
    }
}

packets.register<IfOpenSub> {
    opcode = 16
    write {
        it.writeByteNeg(type)
        it.writeIntIME(targetComponent)
        it.writeShortLE(interfaceId)
    }
}

packets.register<RunClientScript> {
    opcode = 43
    length = PacketLength.Short
    write {
        val types = CharArray(args.size) { i -> if (args[i] is String) 's' else 'i' }
        it.writeStringCP1252(String(types))
        for (i in args.size - 1 downTo 0) {
            val arg = args[i]
            if (arg is String) {
                it.writeStringCP1252(arg)
            } else if (arg is Number) {
                it.writeInt(arg.toInt())
            }
        }
        it.writeInt(id)
    }
}
