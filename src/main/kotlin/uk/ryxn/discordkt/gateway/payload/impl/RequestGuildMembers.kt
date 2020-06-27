package uk.ryxn.discordkt.gateway.payload.impl

import com.google.gson.annotations.SerializedName
import uk.ryxn.discordkt.entities.OmitNull
import uk.ryxn.discordkt.entities.Snowflake
import uk.ryxn.discordkt.gateway.Shard
import uk.ryxn.discordkt.gateway.payload.PayloadData
import uk.ryxn.discordkt.gateway.payload.Payload

open class RequestGuildMembers(
    @Transient
    override val shard: Shard
) : Payload(shard) {

    init {
        setOpcode(PayloadData.REQUEST_GUILD_MEMBERS)
    }

    @SerializedName("d")
    lateinit var data: Data

    companion object {
        fun create(shard: Shard, data: Data): RequestGuildMembers {
            val payload = RequestGuildMembers(shard)
            payload.data = data
            return payload
        }
    }

    // you required to have one of query OR user_ids
    data class Data(
        @SerializedName("guild_id")
        val guildId: List<Snowflake>,

        @SerializedName("query")
        @OmitNull
        val query: String? = null,

        @SerializedName("limit")
        val limit: Int = 0,

        @SerializedName("presences")
        val presences: Boolean = false,

        @SerializedName("user_ids")
        val userIds: List<Snowflake>? = null,

        @SerializedName("nonce")
        val nonce: String? = null
    )
}