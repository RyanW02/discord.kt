package uk.ryxn.discordkt.entities

import com.google.gson.InstanceCreator
import uk.ryxn.discordkt.gateway.Shard
import java.lang.reflect.Type

class EntityInstanceCreator<T : Entity>(val shard: Shard, val clazz: Class<T>) : InstanceCreator<T> {
    override fun createInstance(type: Type?): T {
        return clazz.getDeclaredConstructor(Shard::class.java).newInstance(shard)
    }
}
