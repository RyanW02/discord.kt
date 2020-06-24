package uk.ryxn.discordkt.entities.channel

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ChannelAdapter : JsonDeserializer<Channel> {
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Channel {
        val channelType = ChannelType.getById(json.asJsonObject.get("type").asInt)
        val type = TypeToken.get(channelType.clazz).type
        return context.deserialize(json, type)
    }
}