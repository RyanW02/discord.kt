package uk.ryxn.discordkt.gateway.event.impl.user

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.entities.user.presence.Activity
import uk.ryxn.discordkt.entities.user.presence.ClientStatus
import uk.ryxn.discordkt.entities.user.presence.Status
import uk.ryxn.discordkt.gateway.event.Event
import java.time.OffsetDateTime

// TODO: Role objects
class PresenceUpdate(
    @SerializedName("user")
    val user: User,

    @SerializedName("roles")
    val roleIds: List<Snowflake>,

    @SerializedName("game")
    val game: Activity?,

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
    val nick: String?
) : Event