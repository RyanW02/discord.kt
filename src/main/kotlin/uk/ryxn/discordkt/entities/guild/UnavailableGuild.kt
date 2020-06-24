package uk.ryxn.discordkt.entities.guild

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

data class UnavailableGuild(
    @Transient
    override var shard: Shard,

    @SerializedName("id")
    val id: Snowflake,

    @SerializedName("unavailable")
    val unavailable: Boolean?
) : Entity(shard)