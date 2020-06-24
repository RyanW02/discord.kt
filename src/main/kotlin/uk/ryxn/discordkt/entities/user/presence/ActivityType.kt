package uk.ryxn.discordkt.entities.user.presence

import com.google.gson.annotations.SerializedName

enum class ActivityType {
    @SerializedName("0")
    GAME,

    @SerializedName("1")
    STREAMING,

    @SerializedName("2")
    LISTENING,

    @SerializedName("4")
    CUSTOM,
}