package uk.ryxn.discordkt.gateway.event.impl.guild

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.guild.member.Member
import uk.ryxn.discordkt.entities.guild.member.MemberWithGuild
import uk.ryxn.discordkt.entities.user.presence.Presence
import uk.ryxn.discordkt.gateway.event.Event
import uk.ryxn.discordkt.gateway.event.CustomDeserializer
import uk.ryxn.discordkt.gateway.event.createDeserializer

class GuildMembersChunk(
    @SerializedName("guild_id")
    val guildId: Snowflake,

    @SerializedName("members")
    val members: List<Member>,

    @SerializedName("chunk_index")
    val chunkIndex: Int,

    @SerializedName("chunk_count")
    val chunkCount: Int,

    @SerializedName("not_found")
    val notFound: List<Snowflake>,

    // if passing true to REQUEST_GUILD_MEMBERS, presences of the returned members will be here
    @SerializedName("presences")
    val presences: List<Presence>?,

    @SerializedName("nonce")
    val nonce: String?
) : Event
