package com.example.android_related

import com.example.android_related.PrintNumbers.PrintTaskV2
import com.example.android_related.practices.ABCPrinter
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

interface Base {
    fun print()
}

class BaseImpl: Base {
    override fun print() {
        println("BaseImpl")
    }
}

class Derived(b: Base) : Base by b

val dateFormat = SimpleDateFormat("HH:mm:ss:SSS")

val now = {
    dateFormat.format(Date(System.currentTimeMillis()))
}

fun log(msg: Any?) = println("${now()} [${Thread.currentThread().name}] $msg")

class MyContinuation<T>(private val continuation: Continuation<T>): Continuation<T> {
    override val context: CoroutineContext
        get() = continuation.context

    override fun resumeWith(result: Result<T>) {
        log("<MyContinuation> $result")
        continuation.resumeWith(result)
    }
}

class MyContinuationInterceptor: ContinuationInterceptor {
    override val key: CoroutineContext.Key<*>
        get() = ContinuationInterceptor

    override fun <T> interceptContinuation(continuation: Continuation<T>) = MyContinuation(continuation)
}

fun ordinaryFunction(block: () -> Unit) {
    println("ordinaryFunction")
}

fun foo() {
    ordinaryFunction { return@ordinaryFunction }
    println("foo")
}

lateinit var test: String

fun String.lastChar(): Char {
    return this[length - 1]
}

fun main() {
    val sum = fun Int.(other: Int): Int = this + other
    val s: Int.(Int) -> Int = {it -> plus(it)}
    val str = "hello"
    str.lastChar()
}