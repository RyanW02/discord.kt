package uk.ryxn.discordkt.entities

import com.google.gson.*
import java.lang.reflect.Type

typealias Snowflake = ULong

@ExperimentalUnsignedTypes
class SnowflakeAdapter : JsonDeserializer<Snowflake>, JsonSerializer<Snowflake> {
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext) =
        json.asString.toULong()

    override fun serialize(src: Snowflake, typeOfSrc: Type, context: JsonSerializationContext) =
        JsonPrimitive(src.toString())
}
