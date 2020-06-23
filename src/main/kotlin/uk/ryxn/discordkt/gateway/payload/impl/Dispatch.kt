package uk.ryxn.discordkt.gateway.payload.impl

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.EventType
import uk.ryxn.discordkt.gateway.payload.Payload

class Dispatch(
    @Transient
    override val shard: Shard
) : Payload(shard) {
    @SerializedName("d")
    lateinit var raw: JsonObject

    @SerializedName("t")
    lateinit var eventType: EventType

    val event: Event by lazy {
        shard.gson.fromJson(raw, eventType.clazz)
    }
}