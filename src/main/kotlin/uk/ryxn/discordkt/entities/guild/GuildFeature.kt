package uk.ryxn.discordkt.entities.guild

import com.google.gson.annotations.SerializedName

enum class GuildFeature {
    @SerializedName("INVITE_SPLASH")
    INVITE_SPLASH,

    @SerializedName("VIP_REGIONS")
    VIP_REGIONS,

    @SerializedName("VANITY_URL")
    VANITY_URL,

    @SerializedName("VERIFIED")
    VERIFIED,

    @SerializedName("PARTNERED")
    PARTNERED,

    @SerializedName("PUBLIC")
    PUBLIC,

    @SerializedName("COMMERCE")
    COMMERCE,

    @SerializedName("NEWS")
    NEWS,

    @SerializedName("DISCOVERABLE")
    DISCOVERABLE,

    @SerializedName("FEATURABLE")
    FEATURABLE,

    @SerializedName("ANIMATED_ICON")
    ANIMATED_ICON,

    @SerializedName("BANNER")
    BANNER,

    @SerializedName("PUBLIC_DISABLED")
    PUBLIC_DISABLED,

    @SerializedName("WELCOME_SCREEN_ENABLED")
    WELCOME_SCREEN_ENABLED,
}
