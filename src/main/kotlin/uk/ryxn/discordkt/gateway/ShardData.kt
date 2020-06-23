package uk.ryxn.discordkt.gateway

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type

data class ShardData(val shardId: Int, val totalShards: Int)

class ShardDataAdapter : JsonSerializer<ShardData> {

    override fun serialize(src: ShardData, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        val array = JsonArray(2)
        array.add(src.shardId)
        array.add(src.totalShards)
        return array
    }
}
