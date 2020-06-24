package uk.ryxn.discordkt.entities

import com.google.gson.*
import java.lang.reflect.Type
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class ISO8601Adapter : JsonSerializer<OffsetDateTime>, JsonDeserializer<OffsetDateTime> {
    override fun serialize(src: OffsetDateTime, typeOfSrc: Type, context: JsonSerializationContext) =
        JsonPrimitive(src.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext) =
        OffsetDateTime.from(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(json.asString))
}