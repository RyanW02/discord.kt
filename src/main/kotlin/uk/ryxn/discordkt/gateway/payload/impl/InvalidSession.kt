package uk.ryxn.discordkt.gateway.payload.impl

import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.runBlocking
import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.payload.Payload

class InvalidSession(
    @Transient
    override val shard: Shard
) : Payload(shard) {

    @SerializedName("d")
    var resumable: Boolean = false

    override suspend fun handle(shard: Shard) {
        if (!resumable) {
            shard.sessionId.set("")
        }

        shard.kill()
        shard.connect()
    }
}