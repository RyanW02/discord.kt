package uk.ryxn.discordkt.entities.user.presence

import com.google.gson.annotations.SerializedName

data class Timestamps(
    @SerializedName("start")
    val start: Long?, // millis since unix epoch

    @SerializedName("end")
    val end: Long? // millis since unix epoch
)