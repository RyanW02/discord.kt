package uk.ryxn.discordkt.gateway.payload

import com.google.gson.InstanceCreator
import uk.ryxn.discordkt.gateway.Shard
import java.lang.reflect.Type

class PayloadInstanceCreator<T : Payload>(val shard: Shard, val clazz: Class<T>) : InstanceCreator<T> {
    override fun createInstance(type: Type?): T {
        return clazz.getDeclaredConstructor(Shard::class.java).newInstance(shard)
    }
}
