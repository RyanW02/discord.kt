package uk.ryxn.discordkt.entities.message

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake

class Attachment (
    @SerializedName("id")
    val id: Snowflake,

    @SerializedName("filename")
    val fileName: String,

    @SerializedName("size")
    val size: Int,

    @SerializedName("url")
    val url: String,

    @SerializedName("proxy_url")
    val proxyUrl: String,

    @SerializedName("height")
    val height: Int?,

    @SerializedName("width")
    val width: Int?
)