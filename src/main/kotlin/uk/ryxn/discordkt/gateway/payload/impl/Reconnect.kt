package uk.ryxn.discordkt.gateway.payload.impl

import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.payload.Payload

class Reconnect(
    @Transient
    override val shard: Shard
) : Payload(shard) {
    override suspend fun handle(shard: Shard) {
        shard.kill()
        shard.connect()
    }
}