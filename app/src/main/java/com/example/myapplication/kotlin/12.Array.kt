package com.example.myapplication.kotlin

//20201103
// 12. 배열

// 배열이 필요한 이유
// - 그룹이 필요할

fun main(array:Array<String>){

    // 배열을 생성하는 방법 (1)
    var number: Int = 10
    var group1 = arrayOf<Int>(1, 2, 3, 4, 5) // int 만 들어갈 수 있는 배열

    println(group1 is Array)

    // 배열을 생성하는 방법 (2)
    var number1 = 10
    var group2 = arrayOf(1, 2, 3.5, "HELLO") // 타입을 선언하지 않으면 여러가지 타입을 넣을 수 있다. -> 비추

    // Index -> 순서(번째)
    // [1, 2, 3, 4, 5] -> 0부터 시작
    // index 0 -> 1, index 1 -> 2

    // 배열의 값을 꺼내는 방법 (1)
    val test1 = group1.get(0)
    val test2= group2.get(1)

    println()
    println(test1)
    println(test2)

    // 배열의 값을 꺼내는 방법 (2)
    val test3 = group1[0]
    println()
    println(test3)

    // 배열의 값을 바꾸는 방법 (1)
    group1.set(0, 100)
    println()
    println(group1[0])

    // 배열의 값을 바꾸는 방법 (2)
    group1[0] = 200
    println()
    println(group1[0])
}