package uk.ryxn.discordkt.entities.guild

import com.google.gson.annotations.SerializedName

enum class MFALevel {
    @SerializedName("0")
    NONE,

    @SerializedName("1")
    ELEVATED,
}