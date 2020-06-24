package uk.ryxn.discordkt.gateway.event.impl

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.guild.Guild
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer

class GuildBanAdd(
    @SerializedName("guild_id")
    val guildId: Snowflake,

    @SerializedName("user")
    val user: User
) : Event
