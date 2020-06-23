package uk.ryxn.discordkt.entities.user

import com.google.gson.annotations.SerializedName

enum class PremiumType {
    @SerializedName("0")
    NONE,

    @SerializedName("1")
    NITRO_CLASSIC,

    @SerializedName("2")
    NITRO,
    ;

    fun isNitro() = ordinal >= 1
}
