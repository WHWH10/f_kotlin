package com.example.myapplication.kotlin

//20201030
// 08. 제어흐름

// 1. if - else

fun main(array: Array<String>) {
    val a: Int = 5
    val b: Int = 10

    // if - else 사용법 (1)
    if (a > b) {
        println("a 가 b 보다 크다")
    } else {
        println("a 가 b 보다 작다")
    }

    // if - else 사용법 (1)
    println()
    if (a > b) {
        println("a 가 b 보다 크다")
    }

    if (a < b) println("a 가 b 보다 작다")

    // if/else/else-if 사용법 (3)
    println()
    if (a > b) {
        println("a 가 b 보다 크다")
    } else if (a < b) {
        println("a 가 b 보다 작다")
    } else if (a == b) {
        println("a 와 b 는 같다")
    } else {
        println("모두 아닐 때")
    }

    // 값을 리턴하는 if 사용법
    val max = if (a > b) {
        a // 5
    } else {
        b //10
    }
    val max1 = if (a > b) a else b

    println()
    println(max)
    println(max1)
}