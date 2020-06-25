package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Entity
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

@JsonAdapter(ChannelAdapter::class)
open class Channel(shard: Shard) : Entity(shard) {
    @SerializedName("id")
    var id: Snowflake = 0u
        private set

    @SerializedName("type")
    lateinit var type: ChannelType
        private set
}
