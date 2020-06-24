package uk.ryxn.discordkt.gateway.event

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class EventTypeAdapter : JsonDeserializer<EventType> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?) =
        EventType.values().firstOrNull { json?.asString == it.eventName }
}
