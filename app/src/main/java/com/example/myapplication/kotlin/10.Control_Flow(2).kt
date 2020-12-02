package com.example.myapplication.kotlin

//20201030
// 10. Control_Flow(2) -> 제어흐름B

//when

fun main(array: Array<String>) {
    val value: Int = 3

    // when 안에 들어가는 조건이 반드시 true 이거나 false 일 필요가 없다
    when (value) {
        1 -> {
            println("value is 1")
        }
        2 -> {
            println("value is 2")
        }
        3 -> {
            println("value is 3")
        }
        else -> println("I do not know value")
    }

    println()
    if (value == 1) {
        println("value is 1")
    } else if (value == 2) {
        println("value is 2")
    } else if (value == 3) {
        println("value is 3")
    } else println("I do not know value")

    println()
    val value2 = when(value){
        1 -> 10
        2 -> 20
        3 -> 30
        else -> "NOTHING"
    }
    println(value2)

}