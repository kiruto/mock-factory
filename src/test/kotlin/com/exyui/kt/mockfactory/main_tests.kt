package com.exyui.kt.mockfactory

import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.reflect.KVisibility
import kotlin.reflect.jvm.isAccessible

class GlobalFunctionsTest {

    @Test fun testBasicType() {
        listOf(
                "0".isBasicType(),
                0.isBasicType(),
                true.isBasicType(),
                '0'.isBasicType(),
                0L.isBasicType(),
                .0.isBasicType(),
                object {}.isNotBasicType()
        ).forEach(::assertTrue)
    }

    @Test fun testConstructor() {
        ExampleA::class.constructors.forEach { constructor ->
            if(constructor.visibility != KVisibility.PUBLIC)
                return
            val p = mutableListOf<Any?>()
            constructor.parameters.forEach { param ->
                p.add(when (param.type.classifier) {
                    Int::class -> 0
                    Boolean::class -> true
                    else -> null
                })
            }
            println(constructor.call(*p.toTypedArray()))
        }
    }

    data class ExampleA private constructor(val a: Int, val b: Boolean) {
        constructor(): this(-1, false)
        constructor(a: Int): this(a, false)
        constructor(b: Boolean): this(-1, b)
    }
}