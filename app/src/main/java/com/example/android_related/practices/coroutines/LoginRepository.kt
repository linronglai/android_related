package com.example.android_related.practices.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.Result

class LoginRepository {

    suspend fun makeRequest(): Result<Any> {
        //return Result.Success<String>("success")
        return withContext(Dispatchers.IO) {
            Result.Success<String>("success")
        }
    }

    sealed class Result<out R> {
        data class Success<out T>(val data: T) : Result<T>()
        data class Error(val exception: Exception) : Result<Nothing>()
    }
}