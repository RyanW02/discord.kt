package uk.ryxn.discordkt.gateway

import com.google.gson.*
import com.google.gson.annotations.JsonAdapter
import java.lang.reflect.Type

@JsonAdapter(ShardDataAdapter::class)
data class ShardData(val shardId: Int, val totalShards: Int)

class ShardDataAdapter : JsonSerializer<ShardData>, JsonDeserializer<ShardData> {

    override fun serialize(src: ShardData, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        val array = JsonArray(2)
        array.add(src.shardId)
        array.add(src.totalShards)
        return array
    }

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): ShardData {
        val array = json.asJsonArray
        return ShardData(array.get(0).asInt, array.get(1).asInt)
    }
}
