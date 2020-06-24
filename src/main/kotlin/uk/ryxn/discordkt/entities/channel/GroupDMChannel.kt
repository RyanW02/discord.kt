package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.entities.user.User
import uk.ryxn.discordkt.gateway.Shard

data class GroupDMChannel(
    @Transient
    override var shard: Shard,

    @SerializedName("owner_id")
    val ownerId: Snowflake
) : DMChannel(shard)