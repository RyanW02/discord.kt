package uk.ryxn.discordkt.entities.message.embed

import com.google.gson.annotations.SerializedName

enum class EmbedType {
    @SerializedName("rich")
    RICH,

    @SerializedName("image")
    IMAGE,

    @SerializedName("video")
    VIDEO,

    @SerializedName("gifv")
    GIFV,

    @SerializedName("article")
    ARTICLE,

    @SerializedName("link")
    LINK,
}