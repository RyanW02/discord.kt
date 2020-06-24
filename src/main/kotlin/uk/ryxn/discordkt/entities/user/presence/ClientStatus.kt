package uk.ryxn.discordkt.entities.user.presence

import com.google.gson.annotations.SerializedName

data class ClientStatus(
    @SerializedName("desktop")
    val desktop: Status?,

    @SerializedName("mobile")
    val mobile: Status?,

    @SerializedName("web")
    val web: Status?
)