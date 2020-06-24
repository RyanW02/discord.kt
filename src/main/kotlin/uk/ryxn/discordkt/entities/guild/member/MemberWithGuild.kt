package uk.ryxn.discordkt.entities.guild.member

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.Shard
import java.time.OffsetDateTime

// TODO: Role IDs
class MemberWithGuild (
    shard: Shard,

    @SerializedName("guild_id")
    val guildId: Snowflake
) : Member(shard)