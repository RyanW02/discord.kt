package uk.ryxn.discordkt.entities.guild.member

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.Shard
import java.time.OffsetDateTime

// TODO: Role IDs
class Member (
    shard: Shard,

    @SerializedName("user")
    val user: User?, // not included in MESSAGE_CREATE or MESSAGE_UPDATE events

    @SerializedName("nick")
    val nick: String?,

    @SerializedName("roles")
    val roleIds: List<Snowflake>,

    @SerializedName("joined_at")
    val joinedAt: OffsetDateTime,

    @SerializedName("premium_since")
    val premiumSince: OffsetDateTime?,

    @SerializedName("deaf")
    val deaf: Boolean,

    @SerializedName("mute")
    val mute: Boolean
) : Entity(shard)