package uk.ryxn.discordkt.entities

import com.google.gson.*
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import uk.ryxn.discordkt.gateway.payload.impl.Identify
import java.lang.reflect.Field

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class OmitNull

// cheers https://stackoverflow.com/a/60265364
class OmitNullAdapter : TypeAdapterFactory {

    fun Field.serializedName() = declaredAnnotations
        .filterIsInstance<SerializedName>()
        .firstOrNull()?.value ?: name

    override fun <T : Any?> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
        val nullableFields = type.rawType.declaredFields
            .filter { it.isAnnotationPresent(OmitNull::class.java) }
            .map { it.serializedName() }

        return if (nullableFields.isEmpty()) {
            null
        } else {
            object : TypeAdapter<T>() {
                val delegate = gson.getDelegateAdapter(this@OmitNullAdapter, type)
                val element = gson.getAdapter(JsonElement::class.java)

                override fun read(reader: JsonReader?) = delegate.read(reader)

                override fun write(out: JsonWriter, value: T) {
                    if (delegate.toJsonTree(value)?.isJsonObject == true) {
                        val obj = delegate.toJsonTree(value).asJsonObject
                        nullableFields
                            .filter { obj.get(it) is JsonNull }
                            .forEach { obj.remove(it) }

                        element.write(out, obj)
                    } else {
                        element.write(out, delegate.toJsonTree(value))
                    }
                }
            }
        }
    }
}