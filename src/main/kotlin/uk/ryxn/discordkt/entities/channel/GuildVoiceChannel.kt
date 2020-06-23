package uk.ryxn.discordkt.entities.channel

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard

class GuildVoiceChannel(shard: Shard) : GuildChannel(shard) {
    @SerializedName("topic")
    var topic: String? = null

    @SerializedName("last_message_id")
    var lastMessageId: Snowflake? = null
}