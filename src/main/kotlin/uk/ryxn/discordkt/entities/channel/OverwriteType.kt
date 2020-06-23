package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.SerializedName

enum class OverwriteType {
    @SerializedName("role")
    ROLE,

    @SerializedName("member")
    MEMBER,
}
