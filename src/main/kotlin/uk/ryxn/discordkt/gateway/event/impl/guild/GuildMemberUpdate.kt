package uk.ryxn.discordkt.gateway.event.impl.guild

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.guild.Guild
import uk.ryxn.discordkt.entities.guild.emoji.Emoji
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer
import java.time.OffsetDateTime

// TODO: Role objects
class GuildMemberUpdate(
    @SerializedName("guild_id")
    val guildId: Snowflake,

    @SerializedName("roles")
    val roleIds: List<Snowflake>,

    @SerializedName("user")
    val user: User,

    @SerializedName("nick")
    val nick: String?,

    @SerializedName("premium_since")
    val premiumSince: OffsetDateTime?
) : Event
