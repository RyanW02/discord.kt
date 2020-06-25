package uk.ryxn.discordkt.entities.message.embed

import com.google.gson.annotations.SerializedName

class EmbedField (
    @SerializedName("name")
    val name: String,

    @SerializedName("value")
    val value: String,

    @SerializedName("inline")
    val inline: Boolean?
)