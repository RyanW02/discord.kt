package uk.ryxn.discordkt.entities.guild

import com.google.gson.annotations.SerializedName

enum class ExplicitContentFilter {
    @SerializedName("0")
    DISABLED,

    @SerializedName("1")
    MEMBERS_WITHOUT_ROLES,

    @SerializedName("2")
    ALL_MEMBERS,
}