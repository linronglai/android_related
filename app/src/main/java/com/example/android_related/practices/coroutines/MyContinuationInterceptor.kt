package com.example.android_related.practices.coroutines

import com.example.android_related.log
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

class MyContinuationInterceptor(override val key: ContinuationInterceptor.Key = ContinuationInterceptor) : ContinuationInterceptor {
    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return MyContinuation<T>(continuation)
    }

    class MyContinuation<T>(private val continuation: Continuation<T>): Continuation<T> {
        override val context: CoroutineContext
            get() = continuation.context

        override fun resumeWith(result: Result<T>) {
            log("<MyCustomContinuationInterceptor>")
            continuation.resumeWith(result)
        }
    }
}