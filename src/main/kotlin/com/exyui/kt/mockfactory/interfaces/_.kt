package com.exyui.kt.mockfactory.interfaces

import kotlin.reflect.KClass
import kotlin.reflect.KFunction

internal interface Application {
    val config: Config
    fun <T> create(clz: Class<T>): T
    fun destroy()
}

internal interface Config {
    fun factory(): Application
    fun dependsOn(vararg obj: Any): Config
    fun firstCall(func: KFunction<*>)
    fun finalCall(func: KFunction<*>)
    fun callOnce(func: KFunction<*>)
    fun mayThrow(func: KFunction<*>, vararg ex: KClass<out Throwable>)
}

internal interface ConfigField {

}

internal interface Setting {

}