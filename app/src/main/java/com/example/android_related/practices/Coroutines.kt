package com.example.android_related.practices

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    GlobalScope.launch(context = Dispatchers.IO) {
        delay(1000)
        log("world")
    }
    log("hello")
    Thread.sleep(3000)
}

private fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")