package uk.ryxn.discordkt.entities.message.embed

import com.google.gson.annotations.SerializedName

class EmbedFooter (
    @SerializedName("text")
    val text: String,

    @SerializedName("icon_url")
    val iconUrl: String?,

    @SerializedName("proxy_icon_url")
    val proxyIconUrl: String?
)