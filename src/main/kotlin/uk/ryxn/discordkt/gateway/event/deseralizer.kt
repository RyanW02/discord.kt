package uk.ryxn.discordkt.gateway.event

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import uk.ryxn.discordkt.entities.guild.Guild
import uk.ryxn.discordkt.gateway.event.impl.guild.GuildCreate
import uk.ryxn.discordkt.utils.typeOf
import java.lang.reflect.Type

inline fun <reified T> createDeserializer(noinline mapper: (JsonElement, Type, JsonDeserializationContext) -> T) =
    JsonDeserializer<T>(mapper)

inline fun <reified T, reified S> defaultDeserializer() = createDeserializer<T> { json, type, ctx ->
    T::class.java.getDeclaredConstructor(S::class.java).newInstance(ctx.deserialize(json, typeOf<S>()))
}
