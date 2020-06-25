package uk.ryxn.discordkt.entities.message.embed

import com.google.gson.annotations.SerializedName

class EmbedAuthor (
    @SerializedName("name")
    val name: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("icon_url")
    val iconUrl: String?,

    @SerializedName("proxy_icon_url")
    val proxyIconUrl: String?
)