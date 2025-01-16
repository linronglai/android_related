package com.example.android_related.practices.leetcode

class Trie() {
    val root = Node()

    fun insert(word: String) {
        var node = root
        for(ch in word) {
            val id = ch - 'a'
            if (node.childen[id] == null) {
                val newNode = Node()
                node.childen[id] = newNode
            }
            node = node.childen[id]
        }
        node.isEnd = true
    }

    fun search(word: String): Boolean {
        var node = root
        for(ch in word) {
            val id = ch - 'a'
            if (node.childen[id] == null) {
                return false
            }
            node = node.childen[id]
        }
        return node.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        for(ch in prefix) {
            val id = ch - 'a'
            if (node.childen[id] == null) {
                return false
            }
            node = node.childen[id]
        }
        return true
    }

}

class Node {
    val childen: Array<Node> = Array(26){ Node() }
    var isEnd: Boolean = false
}