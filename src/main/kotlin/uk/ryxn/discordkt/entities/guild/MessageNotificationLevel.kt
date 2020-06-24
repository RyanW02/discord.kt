package uk.ryxn.discordkt.entities.guild

import com.google.gson.annotations.SerializedName

enum class MessageNotificationLevel {
    @SerializedName("0")
    ALL_MESSAGES,

    @SerializedName("1")
    ONLY_MENTIONS,
}