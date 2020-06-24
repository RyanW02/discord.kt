package uk.ryxn.discordkt.entities.guild.emoji

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.Shard

// TODO: Get role objects
class Emoji (
    shard: Shard,

    @SerializedName("id")
    val id: Snowflake?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("roles")
    val roleIds: List<Snowflake>,

    @SerializedName("user")
    val user: User?,

    @SerializedName("require_colons")
    val requireColons: Boolean?,

    @SerializedName("managed")
    val managed: Boolean?,

    @SerializedName("animated")
    val animated: Boolean?,

    @SerializedName("available")
    val available: Boolean?
) : Entity(shard)