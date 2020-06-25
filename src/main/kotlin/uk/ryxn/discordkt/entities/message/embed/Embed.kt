package uk.ryxn.discordkt.entities.message.embed

import com.google.gson.annotations.SerializedName
import java.time.OffsetDateTime

class Embed(
    @SerializedName("title")
    val title: String?,

    @SerializedName("type")
    val type: EmbedType,

    @SerializedName("description")
    val description: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("timestamp")
    val timestamp: OffsetDateTime?,

    @SerializedName("color")
    val colour: Int,

    @SerializedName("footer")
    val footer: EmbedFooter?,

    @SerializedName("image")
    val image: EmbedImage?,

    @SerializedName("thumbnail")
    val thumbnail: EmbedThumbnail?,

    @SerializedName("video")
    val video: EmbedVideo?,

    @SerializedName("provider")
    val provider: EmbedProvider?,

    @SerializedName("author")
    val author: EmbedAuthor?,

    @SerializedName("fields")
    val fields: List<EmbedField>?
)