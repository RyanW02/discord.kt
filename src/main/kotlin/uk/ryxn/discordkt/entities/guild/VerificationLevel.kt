package uk.ryxn.discordkt.entities.guild

import com.google.gson.annotations.SerializedName

enum class VerificationLevel {
    @SerializedName("0")
    NONE,

    @SerializedName("1")
    LOW,

    @SerializedName("2")
    MEDIUM,

    @SerializedName("3")
    HIGH,

    @SerializedName("4")
    VERY_HIGH,
}