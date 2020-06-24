package uk.ryxn.discordkt.entities.guild.role

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

class Role(
    shard: Shard,

    @SerializedName("id")
    val id: Snowflake,

    @SerializedName("name")
    val name: String,

    @SerializedName("color")
    val color: Int,

    @SerializedName("hoist")
    val hoist: Boolean,

    @SerializedName("position")
    val position: Int,

    @SerializedName("permissions")
    val permissions: Int,

    @SerializedName("managed")
    val managed: Boolean,

    @SerializedName("mentionable")
    val mentionable: Boolean
) : Entity(shard)