package uk.ryxn.discordkt.gateway.event

import com.google.gson.annotations.JsonAdapter
import uk.ryxn.discordkt.gateway.event.impl.*

@JsonAdapter(EventTypeAdapter::class)
enum class EventType(val eventName: String, val clazz: Class<out Event>) {
    READY("READY", Ready::class.java),
    RESUMED("RESUMED", Resumed::class.java),
    RECONNECT("RECONNECT", Reconnect::class.java),
    CHANNEL_CREATE("CHANNEL_CREATE", ChannelCreate::class.java),
    CHANNEL_UPDATE("CHANNEL_UPDATE", ChannelUpdate::class.java),
    CHANNEL_DELETE("CHANNEL_DELETE", ChannelDelete::class.java),
    CHANNEL_PINS_UPDATE("CHANNEL_PINS_UPDATE", ChannelPinsUpdate::class.java),
    GUILD_CREATE("GUILD_CREATE", GuildCreate::class.java),
    GUILD_UPDATE("GUILD_UPDATE", GuildUpdate::class.java),
    GUILD_DELETE("GUILD_DELETE", GuildDelete::class.java),
    GUILD_BAN_ADD("GUILD_BAN_ADD", GuildBanAdd::class.java),
    GUILD_BAN_REMOVE("GUILD_BAN_REMOVE", GuildBanRemove::class.java),
    GUILD_EMOJIS_UPDATE("GUILD_EMOJIS_UPDATE", GuildEmojisUpdate::class.java),
    GUILD_INTEGRATIONS_UPDATE("GUILD_INTEGRATIONS_UPDATE", GuildIntegrationsUpdate::class.java),
    GUILD_MEMBER_ADD("GUILD_MEMBER_ADD", GuildMemberAdd::class.java),
    GUILD_MEMBER_REMOVE("GUILD_MEMBER_REMOVE", GuildMemberRemove::class.java),
    GUILD_MEMBER_UPDATE("GUILD_MEMBER_UPDATE", GuildMemberUpdate::class.java),
    GUILD_MEMBERS_CHUNK("GUILD_MEMBERS_CHUNK", GuildMembersChunk::class.java),
    GUILD_ROLE_CREATE("GUILD_ROLE_CREATE", GuildRoleCreate::class.java),
    GUILD_ROLE_UPDATE("GUILD_ROLE_UPDATE", GuildRoleUpdate::class.java),
    GUILD_ROLE_DELETE("GUILD_ROLE_DELETE", GuildRoleDelete::class.java),
    INVITE_CREATE("INVITE_CREATE", InviteCreate::class.java),
    INVITE_DELETE("INVITE_DELETE", InviteDelete::class.java),
}
