package uk.ryxn.discordkt.entities

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class SkipSerialisation

class SkipSerialisationExclusionStrategy : ExclusionStrategy {
    override fun shouldSkipField(f: FieldAttributes) = f.getAnnotation(SkipSerialisation::class.java) != null

    override fun shouldSkipClass(clazz: Class<*>?) = false
}
