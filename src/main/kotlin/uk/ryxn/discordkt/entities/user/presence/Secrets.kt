package uk.ryxn.discordkt.entities.user.presence

import com.google.gson.annotations.SerializedName

data class Secrets(
    @SerializedName("join")
    val join: String?,

    @SerializedName("spectate")
    val spectate: String?,

    @SerializedName("match")
    val match: String?
)