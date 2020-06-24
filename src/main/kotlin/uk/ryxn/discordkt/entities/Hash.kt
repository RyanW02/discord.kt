package uk.ryxn.discordkt.entities

import com.google.gson.*
import java.lang.reflect.Type

class Hash(val animated: Boolean, val data: ULongArray) {
    override fun toString(): String {
        if (data.size < 2) {
            return ""
        }

        val sb = StringBuilder()

        // append animated prefix
        if (animated) {
            sb.append("a_")
        }

        // append the hash
        sb.append(String.format("%016X", data[0]))
        sb.append(String.format("%016X", data[1]))

        return sb.toString()
    }
}

class HashAdapter : JsonSerializer<Hash>, JsonDeserializer<Hash> {
    override fun serialize(src: Hash, typeOfSrc: Type, context: JsonSerializationContext) =
        JsonPrimitive(src.toString())

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Hash {
        val s = json.asString

        if (s.length != 32 && s.length != 34) {
            return Hash(false, ULongArray(0))
        }

        val animated = s.length == 34
        val bytes = s.toByteArray()

        val first: ByteArray
        val second: ByteArray

        if (animated) {
            first = bytes.copyOfRange(2, 18)
            second = bytes.copyOfRange(18, 34)
        } else {
            first = bytes.copyOfRange(0, 16)
            second = bytes.copyOfRange(16, 32)
        }

        val data = ULongArray(2)
        data[0] = first.toULong()
        data[1] = second.toULong()

        return Hash(animated, data)
    }

    private fun ByteArray.toULong(): ULong {
        var res: ULong = 0u
        for (i in indices) {
            res = res or get(i).toULong() shl (i shl 3)
        }
        return res
    }
}