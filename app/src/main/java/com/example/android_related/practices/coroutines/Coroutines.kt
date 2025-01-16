package com.example.android_related.practices.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

suspend fun getUserInfo(): String {
    withContext(Dispatchers.IO) {
        delay(1000)
    }
    return "BoyCoder"
}

//suspend fun getFriendList(user: String): String {
//    withContext(Dispatchers.IO) {
//        delay(1000)
//    }
//    return "Tom,Jack"
//}

//suspend fun getFeedList(list: String): String {
//    withContext(Dispatchers.IO) {
//        delay(1000)
//    }
//    return "{FeedList..}"
//}

fun main() {
}
