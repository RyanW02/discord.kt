package uk.ryxn.discordkt.core

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import uk.ryxn.discordkt.entities.*
import uk.ryxn.discordkt.entities.user.*
import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.ShardData
import uk.ryxn.discordkt.gateway.ShardDataAdapter
import uk.ryxn.discordkt.gateway.payload.Payload
import uk.ryxn.discordkt.gateway.payload.PayloadInstanceCreator
import uk.ryxn.discordkt.gateway.payload.impl.Dispatch
import uk.ryxn.discordkt.gateway.payload.impl.Heartbeat
import uk.ryxn.discordkt.gateway.payload.impl.Hello
import uk.ryxn.discordkt.gateway.payload.impl.Identify

// contains the gson instance with all type adapters registered, etc.
val gsonBuilder = GsonBuilder()
    .registerTypeAdapter(ShardData::class.java, ShardDataAdapter())
    .registerTypeAdapter(Snowflake::class.java, SnowflakeAdapter())
    .registerTypeAdapter(Discriminator::class.java, DiscriminatorAdapter())
    .registerTypeAdapter(Avatar::class.java, AvatarAdapter())

fun GsonBuilder.withEntityAdapters(shard: Shard) = registerTypeAdapterFactory(EntityAdapterFactory(shard))

inline fun<reified T: Payload> GsonBuilder.registerPayloadAdapter(shard: Shard) {
    registerTypeAdapter(T::class.java, PayloadInstanceCreator(shard, T::class.java))
}

fun GsonBuilder.withPayloadAdapters(shard: Shard): GsonBuilder {
    registerPayloadAdapter<Dispatch>(shard)
    registerPayloadAdapter<Heartbeat>(shard)
    registerPayloadAdapter<Hello>(shard)
    registerPayloadAdapter<Identify>(shard)

    return this
}
