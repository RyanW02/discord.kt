package uk.ryxn.discordkt.gateway.event

import com.google.gson.annotations.JsonAdapter
import uk.ryxn.discordkt.gateway.event.impl.channel.ChannelCreate
import uk.ryxn.discordkt.gateway.event.impl.channel.ChannelDelete
import uk.ryxn.discordkt.gateway.event.impl.channel.ChannelPinsUpdate
import uk.ryxn.discordkt.gateway.event.impl.channel.ChannelUpdate
import uk.ryxn.discordkt.gateway.event.impl.gateway.Ready
import uk.ryxn.discordkt.gateway.event.impl.gateway.Reconnect
import uk.ryxn.discordkt.gateway.event.impl.gateway.Resumed
import uk.ryxn.discordkt.gateway.event.impl.guild.*
import uk.ryxn.discordkt.gateway.event.impl.message.*
import uk.ryxn.discordkt.gateway.event.impl.user.PresenceUpdate
import uk.ryxn.discordkt.gateway.event.impl.user.TypingStart
import uk.ryxn.discordkt.gateway.event.impl.user.UserUpdate
import uk.ryxn.discordkt.gateway.event.impl.voice.VoiceServerUpdate
import uk.ryxn.discordkt.gateway.event.impl.voice.VoiceStateUpdate
import uk.ryxn.discordkt.gateway.event.impl.webhooks.WebhookUpdate

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
    MESSAGE_CREATE("MESSAGE_CREATE", MessageCreate::class.java),
    MESSAGE_UPDATE("MESSAGE_UPDATE", MessageUpdate::class.java),
    MESSAGE_DELETE("MESSAGE_DELETE", MessageDelete::class.java),
    MESSAGE_DELETE_BULK("MESSAGE_DELETE_BULK", MessageDeleteBulk::class.java),
    MESSAGE_REACTION_ADD("MESSAGE_REACTION_ADD", MessageReactionAdd::class.java),
    MESSAGE_REACTION_REMOVE("MESSAGE_REACTION_REMOVE", MessageReactionRemove::class.java),
    MESSAGE_REACTION_REMOVE_ALL("MESSAGE_REACTION_REMOVE_ALL", MessageReactionRemoveAll::class.java),
    MESSAGE_REACTION_REMOVE_EMOJI("MESSAGE_REACTION_REMOVE_EMOJI", MessageReactionRemoveEmoji::class.java),
    PRESENCE_UPDATE("PRESENCE_UPDATE", PresenceUpdate::class.java),
    TYPING_START("TYPING_START", TypingStart::class.java),
    USER_UPDATE("USER_UPDATE", UserUpdate::class.java),
    VOICE_STATE_UPDATE("VOICE_STATE_UPDATE", VoiceStateUpdate::class.java),
    VOICE_SERVER_UPDATE("VOICE_SERVER_UPDATE", VoiceServerUpdate::class.java),
    WEBHOOK_UPDATE("WEBHOOK_UPDATE", WebhookUpdate::class.java),
}
