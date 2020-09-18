package gg.rsmod.plugins.protocol.codec.account

import gg.rsmod.game.model.client.Client
import gg.rsmod.plugins.protocol.Device
import gg.rsmod.util.IsaacRandom
import io.netty.channel.Channel

data class Account(
    val channel: Channel,
    val client: Client,
    val device: Device,
    val decodeIsaac: IsaacRandom,
    val encodeIsaac: IsaacRandom
)
