package uk.ryxn.discordkt.entities.guild

import com.google.gson.annotations.SerializedName

enum class PremiumTier {
    @SerializedName("0")
    NONE,

    @SerializedName("1")
    TIER_1,

    @SerializedName("2")
    TIER_2,

    @SerializedName("3")
    TIER_3,
}