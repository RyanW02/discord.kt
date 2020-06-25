package uk.ryxn.discordkt.entities.message.embed

import com.google.gson.annotations.SerializedName

class EmbedVideo (
    @SerializedName("url")
    val url: String?,

    @SerializedName("height")
    val height: Int?,

    @SerializedName("width")
    val width: Int?
)