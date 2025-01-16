package com.example.android_related.practices

import android.util.Log
import kotlin.reflect.KProperty

class Person(var name: String, var age: Int) {

    var email: String by EmailDelegate()
    val address: String by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        ""
    }

    constructor(): this("Jame", 19) {
        Log.i("", "")
    }

    init {
        Log.i("", "init block")
    }

    infix fun add(other: Person): Person {
        this.age += other.age
        return this
    }

    fun test() {
        val (name, age) = Person("Jame", 12)
    }

    private operator fun component2(): Int {
        return age
    }

    private operator fun component1(): String {
        return name
    }

}

class EmailDelegate() {
    var email: String = ""
    operator fun getValue(person: Person, property: KProperty<*>): String {
        return email
    }

    operator fun setValue(person: Person, property: KProperty<*>, s: String) {
        email = s
    }
}