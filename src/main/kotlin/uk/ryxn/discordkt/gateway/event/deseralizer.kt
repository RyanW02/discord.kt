package uk.ryxn.discordkt.gateway.event

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

inline fun <reified T> createDeserializer(noinline mapper: (JsonElement, Type, JsonDeserializationContext) -> T) =
    JsonDeserializer<T>(mapper)
