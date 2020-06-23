package uk.ryxn.discordkt.core

import com.google.gson.GsonBuilder
import uk.ryxn.discordkt.entities.*
import uk.ryxn.discordkt.entities.user.*
import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.ShardData
import uk.ryxn.discordkt.gateway.ShardDataAdapter

// contains the gson instance with all type adapters registered, etc.
val gsonBuilder = GsonBuilder()
    .registerTypeAdapter(ShardData::class.java, ShardDataAdapter())
    .registerTypeAdapter(Snowflake::class.java, SnowflakeAdapter())
    .registerTypeAdapter(Discriminator::class.java, DiscriminatorAdapter())
    .registerTypeAdapter(Avatar::class.java, AvatarAdapter())

inline fun<reified T: Entity> GsonBuilder.registerEntityAdapter(shard: Shard) {
    registerTypeAdapter(T::class.java, EntityInstanceCreator(shard, T::class.java))
}

fun GsonBuilder.withEntityAdapters(shard: Shard): GsonBuilder {
    registerEntityAdapter<User>(shard)
    return this
}
