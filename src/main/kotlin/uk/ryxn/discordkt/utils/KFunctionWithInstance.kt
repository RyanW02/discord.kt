package uk.ryxn.discordkt.utils

import kotlin.reflect.KFunction
import kotlin.reflect.KParameter
import kotlin.reflect.full.extensionReceiverParameter
import kotlin.reflect.full.instanceParameter

class KFunctionWithInstance<out T>(private val func: KFunction<T>, private val instance: Any) : KFunction<T> by func {
    private val instanceParam = func.instanceParameter ?: func.extensionReceiverParameter
    ?: throw IllegalArgumentException("Given function must not have a instance already bound")

    override fun call(vararg args: Any?) = func.call(instance, *args)

    override fun callBy(args: Map<KParameter, Any?>) = func.callBy(args + (instanceParam to instance))

    override val parameters = func.parameters.filter { it != instanceParam }
}

fun <T> KFunction<T>.withInstance(instance: Any): KFunction<T> = KFunctionWithInstance(this, instance)
