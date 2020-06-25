package uk.ryxn.discordkt.gateway.event.impl.message

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.message.Message
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer

class MessageDeleteBulk(
    @SerializedName("ids")
    val ids: List<Snowflake>,

    @SerializedName("channel_id")
    val channelId: Snowflake,

    @SerializedName("guild_id")
    val guildId: Snowflake?
) : Event
