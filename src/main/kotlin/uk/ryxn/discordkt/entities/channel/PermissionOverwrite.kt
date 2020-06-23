package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake

class PermissionOverwrite {
    @SerializedName("id")
    var id: Snowflake = 0u

    @SerializedName("type")
    lateinit var type: OverwriteType

    @SerializedName("allow")
    var allow: Int = 0

    @SerializedName("deny")
    var deny: Int = 0
}