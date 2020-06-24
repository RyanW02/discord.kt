package uk.ryxn.discordkt.entities.guild

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Hash
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.channel.Channel
import uk.ryxn.discordkt.entities.guild.emoji.Emoji
import uk.ryxn.discordkt.entities.guild.member.Member
import uk.ryxn.discordkt.entities.guild.role.Role
import uk.ryxn.discordkt.entities.user.PremiumType
import uk.ryxn.discordkt.entities.user.presence.Presence
import uk.ryxn.discordkt.entities.voice.VoiceState
import uk.ryxn.discordkt.gateway.Shard
import java.time.OffsetDateTime

open class Guild(
    shard: Shard,

    @SerializedName("name")
    val name: String,

    @SerializedName("icon")
    val icon: Hash?,

    @SerializedName("splash")
    val splash: Hash?,

    @SerializedName("discovery_splash")
    val discoverySplash: Hash?,

    @SerializedName("owner")
    val owner: Boolean,

    @SerializedName("owner_id")
    val ownerId: Snowflake,

    @SerializedName("permissions")
    val permissions: Int?,

    @SerializedName("region")
    val region: String,

    @SerializedName("afk_channel_id")
    val afkChannelId: Snowflake?,

    @SerializedName("afk_timeout")
    val afkTimeout: Int,

    /**
     * @see widgetEnabled
     */
    @SerializedName("embed_enabled")
    @Deprecated("see widgetEnabled")
    val embedEnabled: Boolean?,

    /**
     * @see widgetChannelId
     */
    @SerializedName("embed_channel_id")
    @Deprecated("see widgetChannelId")
    val embedChannelId: Snowflake?,

    @SerializedName("verification_level")
    val verificationLevel: VerificationLevel,

    @SerializedName("default_message_notifications")
    val defaultMessageNotifications: MessageNotificationLevel,

    @SerializedName("explicit_content_filter")
    val explicitContentFilter: ExplicitContentFilter,

    @SerializedName("roles")
    val roles: List<Role>,

    @SerializedName("emojis")
    val emojis: List<Emoji>,

    @SerializedName("features")
    val features: List<GuildFeature>,

    @SerializedName("mfa_level")
    val mfaLevel: MFALevel,

    @SerializedName("application_id")
    val applicationId: Snowflake?,

    @SerializedName("widget_enabled")
    val widgetEnabled: Boolean?,

    @SerializedName("widget_channel_id")
    val widgetChannelId: Snowflake?,

    @SerializedName("system_channel_id")
    val systemChannelId: Snowflake?,

    @SerializedName("system_channel_flags")
    val systemChannelFlags: Int,

    @SerializedName("rules_channel_id")
    val rulesChannelId: Snowflake?,

    @SerializedName("joined_at")
    val joinedAt: OffsetDateTime?, // Only sent on GUILD_CREATE

    @SerializedName("large")
    val large: Boolean?, // Only sent on GUILD_CREATE

    @SerializedName("member_count")
    val memberCount: Int?, // Only sent on GUILD_CREATE

    @SerializedName("voice_states")
    val voiceStates: List<VoiceState>?, // Only sent on GUILD_CREATE

    @SerializedName("members")
    val members: List<Member>?, // Only sent on GUILD_CREATE

    @SerializedName("channels")
    val channels: List<Channel>?, // Only sent on GUILD_CREATE

    @SerializedName("presences")
    val presences: List<Presence>?, // Only sent on GUILD_CREATE

    @SerializedName("max_presences")
    val maxPresences: Int?, // if null, value is 25000

    @SerializedName("max_members")
    val maxMembers: Int?,

    @SerializedName("vanity_url_code")
    val vanityUrlCode: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("banner")
    val banner: String?,

    @SerializedName("premium_tier")
    val boostLevel: PremiumTier,

    @SerializedName("premium_subscription_count")
    val boosts: Int?,

    @SerializedName("preferred_locale")
    val preferredLocal: String,

    @SerializedName("public_updates_channel_id")
    val publicUpdatesChannelId: Snowflake?,

    @SerializedName("max_video_channel_users")
    val maxVideoChannelUsers: Int?,

    @SerializedName("approximate_member_count")
    val approximateMemberCount: Int?,

    @SerializedName("approximate_presence_count")
    val approximatePresenceCount: Int?
) : UnavailableGuild(shard) {
    fun hasSystemChannelFlag(flag: SystemChannelFlag) = (systemChannelFlags and flag.value) == flag.value
}