package uk.ryxn.discordkt.entities

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import uk.ryxn.discordkt.gateway.Shard

class EntityAdapterFactory(val shard: Shard) : TypeAdapterFactory {
    override fun <T : Any?> create(gson: Gson, type: TypeToken<T>?): TypeAdapter<T> {
        val delegate = gson.getDelegateAdapter(this, type)

        return object : TypeAdapter<T>() {
            override fun write(writer: JsonWriter, value: T) = delegate.write(writer, value)

            override fun read(reader: JsonReader): T {
                val t = delegate.read(reader)

                if (t is Entity) {
                    t.shard = shard
                }

                return t
            }
        }
    }
}