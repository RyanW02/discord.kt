package uk.ryxn.discordkt.entities.message.embed

import com.google.gson.annotations.SerializedName

class EmbedProvider (
    @SerializedName("name")
    val name: String?,

    @SerializedName("url")
    val url: String?
)