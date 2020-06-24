package uk.ryxn.discordkt.entities.user.presence

import com.google.gson.annotations.SerializedName

enum class Status {
    @SerializedName("idle")
    IDLE,

    @SerializedName("dnd")
    DO_NOT_DISTURB,

    @SerializedName("online")
    ONLINE,

    @SerializedName("offline")
    OFFLINE,
}