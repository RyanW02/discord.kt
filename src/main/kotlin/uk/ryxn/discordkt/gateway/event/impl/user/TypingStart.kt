package uk.ryxn.discordkt.gateway.event.impl.user

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.guild.member.Member
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.entities.user.presence.Activity
import uk.ryxn.discordkt.entities.user.presence.ClientStatus
import uk.ryxn.discordkt.entities.user.presence.Status
import uk.ryxn.discordkt.gateway.event.Event
import java.time.OffsetDateTime

class TypingStart(
    @SerializedName("channel_id")
    val channelId: Snowflake,

    @SerializedName("guild_id")
    val guildId: Snowflake?,

    @SerializedName("user_id")
    val userId: Snowflake,

    @SerializedName("timestamp")
    val timestamp: Long, // millis since unix epoch

    @SerializedName("member")
    val member: Member?
) : Event