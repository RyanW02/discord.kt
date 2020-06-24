package uk.ryxn.discordkt.entities.user.presence

import com.google.gson.annotations.SerializedName

data class Assets(
    @SerializedName("large_image")
    val largeImage: String?, // usually a snowflake

    @SerializedName("large_text")
    val largeText: String?,

    @SerializedName("small_image")
    val smallImage: String?, // usually a snowflake

    @SerializedName("small_text")
    val smallText: String?
)