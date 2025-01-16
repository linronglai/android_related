package com.example.android_related.practices.leetcode

import java.util.Stack

// 使用栈实现队列
class MyQueue() {
    private val normalStack = Stack<Int>()
    private val reverseStack = Stack<Int>()

    fun push(x: Int) {
        normalStack.push(x)
    }

    fun pop(): Int {
        if (!reverseStack.isEmpty()) {
            return reverseStack.pop()
        }
        while(!normalStack.isEmpty()) {
            reverseStack.push(normalStack.pop())
        }
        return reverseStack.pop()
    }

    fun peek(): Int {
        if (!reverseStack.isEmpty()) {
            return reverseStack.peek()
        }
        while(!normalStack.isEmpty()) {
            reverseStack.push(normalStack.pop())
        }
        return reverseStack.peek()
    }

    fun empty(): Boolean {
        return normalStack.isEmpty() && reverseStack.isEmpty()
    }

}