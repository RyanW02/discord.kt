package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

open class AbstractGuildTextChannel(shard: Shard) : TextChannel(shard), GuildChannel {
    @SerializedName("guild_id")
    override var guildId: Snowflake = 0u

    @SerializedName("position")
    override var position: Int = 0

    @SerializedName("permission_overwrites")
    override var permissionOverwrites: List<PermissionOverwrite> = emptyList()

    @SerializedName("name")
    override var name: String? = null

    @SerializedName("nsfw")
    override var nsfw: Boolean = false

    @SerializedName("parent_id")
    override var parentId: Snowflake? = null

    @SerializedName("topic")
    var topic: String? = null
}