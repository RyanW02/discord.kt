package uk.ryxn.discordkt.gateway.event

import com.google.gson.JsonDeserializer

abstract class CustomDeserializer<T : Event> {
    abstract val deserializer: JsonDeserializer<out T>
}