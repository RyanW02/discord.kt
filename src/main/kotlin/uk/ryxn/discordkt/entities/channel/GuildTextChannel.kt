package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

data class GuildTextChannel(
    @Transient
    override var shard: Shard,

    // seconds
    // 0-21600
    @SerializedName("rate_limit_per_user")
    val rateLimitPerUser: Short = 0
) : AbstractGuildTextChannel(shard)