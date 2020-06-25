package uk.ryxn.discordkt.utils

import com.google.gson.reflect.TypeToken
import kotlin.reflect.KAnnotatedElement
import kotlin.reflect.KType
import kotlin.reflect.full.createType
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.jvm.jvmErasure

inline fun <reified T : Annotation> KAnnotatedElement.hasAnnotation(): Boolean =
    findAnnotation<T>() != null

inline fun <reified T> kTypeOf() = T::class.createType()

inline fun <reified T> typeOf() = TypeToken.get(T::class.java).type
