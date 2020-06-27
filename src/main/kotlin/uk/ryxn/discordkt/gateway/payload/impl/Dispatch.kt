package uk.ryxn.discordkt.gateway.payload.impl

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.EventType
import uk.ryxn.discordkt.gateway.event.impl.gateway.Ready
import uk.ryxn.discordkt.gateway.payload.Payload

class Dispatch(
    @Transient
    override val shard: Shard
) : Payload(shard) {
    @SerializedName("d")
    lateinit var raw: JsonElement

    @SerializedName("t")
    lateinit var eventType: EventType

    val event: Event by lazy {
        shard.gson.fromJson(raw, eventType.clazz)
    }

    override suspend fun handle(shard: Shard) {
        // update session id
        if (eventType == EventType.READY) {
            shard.sessionId.set((event as Ready).sessionId)
        }

        shard.shardManager.executeEvent(event)
    }
}