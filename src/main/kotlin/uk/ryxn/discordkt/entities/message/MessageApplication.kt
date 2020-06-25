package uk.ryxn.discordkt.entities.message

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake

class MessageApplication (
    @SerializedName("id")
    val id: Snowflake,

    @SerializedName("cover_image")
    val coverImage: String?,

    @SerializedName("description")
    val description: String,

    @SerializedName("icon")
    val icon: String?,

    @SerializedName("name")
    val name: String
)