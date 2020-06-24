package uk.ryxn.discordkt.entities.user.presence

import com.google.gson.*
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type

data class Party(
    @SerializedName("id")
    val id: String?,

    @SerializedName("size")
    val size: PartySize
)

@JsonAdapter(PartySizeAdapter::class)
data class PartySize(val currentSize: Int, val maxSize: Int)

class PartySizeAdapter : JsonSerializer<PartySize>, JsonDeserializer<PartySize> {

    override fun serialize(src: PartySize, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        val array = JsonArray(2)
        array.add(src.currentSize)
        array.add(src.maxSize)
        return array
    }

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): PartySize {
        val array = json.asJsonArray
        return PartySize(array.get(0).asInt, array.get(1).asInt)
    }
}
