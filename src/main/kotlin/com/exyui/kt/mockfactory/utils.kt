package com.exyui.kt.mockfactory

fun Any.isBasicType(): Boolean {
    return when(this) {
        is Boolean, is Int, is Long, is Float, is Double, is Short, is Byte, is Char, is String -> true
        else -> false
    }
}

fun Any.isNotBasicType(): Boolean = !isBasicType()

fun timing(block: () -> Unit): Long {
    return System.currentTimeMillis().let {
        block.invoke()
        System.currentTimeMillis() - it
    }
}