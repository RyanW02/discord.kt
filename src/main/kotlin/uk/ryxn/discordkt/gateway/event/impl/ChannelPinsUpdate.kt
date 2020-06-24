package uk.ryxn.discordkt.gateway.event.impl

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.channel.Channel
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZonedDateTime

class ChannelPinsUpdate(
    @SerializedName("guild_id")
    val guildId: Snowflake?,

    @SerializedName("channel_id")
    val channelId: Snowflake?,

    @SerializedName("last_pin_timestamp")
    val lastPinTimestamp: OffsetDateTime
) : Event
