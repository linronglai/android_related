package com.example.android_related.practices

class Singleton private constructor(){

    companion object {
        val INSTANCE by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Singleton()
        }
    }

    @JvmOverloads fun setProperty(name: String = "null", age: Int = 18) {

    }
}
