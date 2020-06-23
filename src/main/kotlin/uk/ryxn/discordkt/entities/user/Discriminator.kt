package uk.ryxn.discordkt.entities.user

import com.google.gson.*
import java.lang.reflect.Type

typealias Discriminator = Short

@ExperimentalUnsignedTypes
class DiscriminatorAdapter : JsonDeserializer<Discriminator>, JsonSerializer<Discriminator> {
    override fun serialize(src: Discriminator, typeOfSrc: Type, context: JsonSerializationContext) =
        JsonPrimitive(String.format("%04d", src))

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext) =
        json.asString.toShort()
}
