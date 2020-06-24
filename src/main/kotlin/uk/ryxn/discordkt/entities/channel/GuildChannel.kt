package uk.ryxn.discordkt.entities.channel

import uk.ryxn.discordkt.entities.Snowflake

interface GuildChannel {
    val guildId: Snowflake
    val position: Int
    val permissionOverwrites: List<PermissionOverwrite>
    val name: String?
    val nsfw: Boolean
    val parentId: Snowflake?
}