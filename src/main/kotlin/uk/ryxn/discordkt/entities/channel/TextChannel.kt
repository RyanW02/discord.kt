package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

open class TextChannel(shard: Shard) : Channel(shard) {
    @SerializedName("last_message_id")
    var lastMessageId: Snowflake? = null
}