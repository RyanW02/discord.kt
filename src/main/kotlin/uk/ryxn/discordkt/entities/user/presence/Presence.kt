package uk.ryxn.discordkt.entities.user.presence

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.Shard
import java.time.OffsetDateTime

// TODO: Get user roles
class Presence (
    shard: Shard,

    @SerializedName("user")
    val user: User,

    @SerializedName("roles")
    val roleIds: List<Snowflake>,

    @SerializedName("activity")
    val activity: Activity,

    @SerializedName("guild_id")
    val guildId: Snowflake,

    @SerializedName("status")
    val status: Status,

    @SerializedName("activities")
    val activities: List<Activity>,

    @SerializedName("client_status")
    val clientStatus: ClientStatus,

    @SerializedName("premium_since")
    val premiumSince: OffsetDateTime?,

    @SerializedName("nick")
    val nick: String
) : Entity(shard)