package com.example.myapplication.kotlin

//20201105
// 16. 반복문(1)


fun main(array: Array<String>) {

    val a = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // 반복하는 방법 (1)
    for (item in a) {
//        println(item)
        if (item == 5) {
            println("item is Five")
        } else {
            println("item is not Five")
        }
    }
    println()

    // 반복하는 방법 (2)
    for ((index, item) in a.withIndex()) {
        println("index : " + index + " value: " + item)
        // 문자열 + Int (정수) = 문자열
        // 문자열 + 아무거나 = 문자
    }
    println()

    // 반복하는 방법 (3)
    a.forEach {
        println(it)
    }
    println()

    // 반복하는 방법 (4)
    a.forEach { item ->
        println(item)
    }

    // 반복하는 방법 (5)
    // 반복하는 방법 (2) 의 람다
    a.forEachIndexed { index, item ->
        println("index : " + index + " value: " + item)
    }
    println()

    // 반복하는 방법 (6)
    for (i in 0 until a.size) {
        // until 은 마지막을 포함하지 않는다
        // 0 부터 8 까지 이다 (a.size = 9)
        println(a.get(i))
    }
    println()

    // 반복하는 방법 (7)
    for (i in 0 until a.size step (2)) {
        // 2씩 증가하는 법 (step)
        println(a.get(i)) // 0 을 포함한 짝수번째만 출
    }
    println()

    // 반복하는 방법 (8)
    for (i in a.size - 1 downTo (0)) {
        // 8 부터 downTo 적어놓은 곳(0) 꺄지 반복
        println(a.get(i))
    }
    println()

    // 반복하는 방법 (9)
    for (i in a.size - 1 downTo (0) step (2)) {
        println(a.get(i))
    }
    println()

    // 반복하는 방법 (10)
    for (i in 0..10) {
        // until -> 마지막 포함 X
        // .. -> 마지막 포함 O
        println(i)
    }
    println()

    // 반복하는 방법 (11)
    var b: Int = 0 // -> 1 -> 2 -> 3 -> 4
    var c: Int = 4

    // while 조건을 깨주는 코드가 들어가야한다
    while (b < c) {
        b++ // while 문을 정지 시키기 위한 코드
        println("b")
    }
    println()

    // 반복하는 방법 (12)
    // while 조건을 만족하지 못해도 무조건 do 안에 한번은 돈다.
    var d: Int = 0
    var e: Int = 4
    do {
        println("hello")
        d++ // 조건 깨주기 위한 코드
    } while( d < e)
}