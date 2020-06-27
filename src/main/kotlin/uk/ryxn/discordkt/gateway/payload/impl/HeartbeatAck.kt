package uk.ryxn.discordkt.gateway.payload.impl

import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.payload.Payload

class HeartbeatAck(
    @Transient
    override val shard: Shard
) : Payload(shard) {

    override suspend fun handle(shard: Shard) {
        shard.lastAck.set(System.currentTimeMillis())
    }
}