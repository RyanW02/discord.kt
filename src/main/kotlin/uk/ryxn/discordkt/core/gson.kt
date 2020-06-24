package uk.ryxn.discordkt.core

import com.google.gson.GsonBuilder
import uk.ryxn.discordkt.entities.*
import uk.ryxn.discordkt.entities.channel.Channel
import uk.ryxn.discordkt.entities.channel.ChannelAdapter
import uk.ryxn.discordkt.entities.user.*
import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.ShardData
import uk.ryxn.discordkt.gateway.ShardDataAdapter
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.impl.ChannelCreate
import uk.ryxn.discordkt.gateway.event.impl.ChannelDelete
import uk.ryxn.discordkt.gateway.event.impl.ChannelUpdate
import uk.ryxn.discordkt.gateway.payload.Payload
import uk.ryxn.discordkt.gateway.payload.PayloadInstanceCreator
import uk.ryxn.discordkt.gateway.payload.impl.Dispatch
import uk.ryxn.discordkt.gateway.payload.impl.Heartbeat
import uk.ryxn.discordkt.gateway.payload.impl.Hello
import uk.ryxn.discordkt.gateway.payload.impl.Identify
import java.time.OffsetDateTime
import kotlin.reflect.full.companionObjectInstance

// contains the gson instance with all type adapters registered, etc.
val gsonBuilder = GsonBuilder()
    .registerTypeAdapter(ShardData::class.java, ShardDataAdapter())
    .registerTypeAdapter(Snowflake::class.java, SnowflakeAdapter())
    .registerTypeAdapter(Discriminator::class.java, DiscriminatorAdapter())
    .registerTypeAdapter(Hash::class.java, HashAdapter())
    .registerTypeAdapter(Channel::class.java, ChannelAdapter())
    .registerTypeAdapter(OffsetDateTime::class.java, ISO8601Adapter())

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

inline fun<reified T: Event> GsonBuilder.registerEventAdapter() {
    registerTypeAdapter(T::class.java, (T::class.companionObjectInstance as CustomDeserializer<*>).deserializer)
}

fun GsonBuilder.withEventAdapters(): GsonBuilder {
    registerEventAdapter<ChannelCreate>()
    registerEventAdapter<ChannelUpdate>()
    registerEventAdapter<ChannelDelete>()

    return this
}
