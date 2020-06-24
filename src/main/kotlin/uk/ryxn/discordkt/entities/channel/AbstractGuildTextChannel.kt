package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

abstract class AbstractGuildTextChannel(shard: Shard) : TextChannel(shard), GuildChannel {
    @SerializedName("guild_id")
    override val guildId: Snowflake = 0u

    @SerializedName("position")
    override val position: Int = 0

    @SerializedName("permission_overwrites")
    override val permissionOverwrites: List<PermissionOverwrite> = emptyList()

    @SerializedName("name")
    override val name: String? = null

    @SerializedName("nsfw")
    override val nsfw: Boolean = false

    @SerializedName("parent_id")
    override val parentId: Snowflake? = null

    @SerializedName("topic")
    val topic: String? = null
}
