package com.example.myapplication.kotlin

//20201030
// 09. Control_Flow Practice -> 제어흐름 A 실습

fun main(array: Array<String>) {
    val a: Int? = null
    val b: Int = 10
    val c: Int = 100

    if (a == null) {
        println("a is null")
    } else {
        println("a is not null")
    }

    if (b + c == 110) {
        println("b plus c is 110")
    } else {
        println("b plus c is not 110")
    }

    // 엘비스 연산자 (null 에 대응하기 위해 많이 쓰여지는 연산자)
    val number: Int? = null
//    val number: Int? = 100
    val number2 = number ?: 10 //(number 가 null 인 경우 10이 들어간다)

    println()
    println(number2)

    val num1: Int = 10
    val num2: Int = 20

    // 값을 return 하는 if 문에서는 반드시 리턴값이 있어야 한다
    val max = if(num1 > num2) {
        num1
    } else if (num1 == num2){
        num2
    } else {
        num1 + num2
    }

    println()
    println(max)
}