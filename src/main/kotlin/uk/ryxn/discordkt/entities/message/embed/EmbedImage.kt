package uk.ryxn.discordkt.entities.message.embed

import com.google.gson.annotations.SerializedName

class EmbedImage (
    @SerializedName("url")
    val url: String?,

    @SerializedName("proxy_url")
    val proxyUrl: String?,

    @SerializedName("height")
    val height: Int?,

    @SerializedName("width")
    val width: Int?
)