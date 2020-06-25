package uk.ryxn.discordkt.gateway.event.impl.voice

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.entities.user.presence.Activity
import uk.ryxn.discordkt.entities.user.presence.ClientStatus
import uk.ryxn.discordkt.entities.user.presence.Status
import uk.ryxn.discordkt.gateway.event.Event
import java.time.OffsetDateTime

class VoiceServerUpdate(
    @SerializedName("token")
    val token: String,

    @SerializedName("guild_id")
    val guildId: Snowflake,

    @SerializedName("endpoint")
    val endpoint: String
) : Event