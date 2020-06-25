package uk.ryxn.discordkt.entities.message

import com.google.gson.annotations.SerializedName

enum class MessageType {
    @SerializedName("0")
    DEFAULT,

    @SerializedName("1")
    RECIPIENT_ADD,

    @SerializedName("2")
    RECIPIENT_REMOVE,

    @SerializedName("3")
    CALL,

    @SerializedName("4")
    CHANNEL_NAME_CHANGE,

    @SerializedName("5")
    CHANNEL_ICON_CHANGE,

    @SerializedName("6")
    CHANNEL_PINNED_MESSAGE,

    @SerializedName("7")
    GUILD_MEMBER_JOIN,

    @SerializedName("8")
    USER_PREMIUM_GUILD_SUBSCRIPTION,

    @SerializedName("9")
    USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_1,

    @SerializedName("10")
    USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_2,

    @SerializedName("11")
    USER_PREMIUM_GUILD_SUBSCRIPTION_TIER_3,

    @SerializedName("12")
    CHANNEL_FOLLOW_ADD,

    @SerializedName("14")
    GUILD_DISCOVERY_DISQUALIFIED,

    @SerializedName("15")
    GUILD_DISCOVERY_REQUALIFIED,
}