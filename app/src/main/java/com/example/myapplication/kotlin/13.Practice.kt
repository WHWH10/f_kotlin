package com.example.myapplication.kotlin

//20201103
// 13. 배열 실습

fun main(array: Array<String>) {
    val array = arrayOf<Int>(1, 2, 3)

    // get, set
    val number = array.get(0)
    println(number)
//    val number1 = array.get(100) // index 에 주의해야 한다.
    array.set(0, 100)
    val number2 = array.get(0)
    println(number2)

//    array.set(100, 100)
    // array 의 Bounds - 처음 만들 때 결정 된다.

    // Array 를 만드는 방법 (3)
    val a1 = intArrayOf(1, 2, 3)
    val a2 = charArrayOf('A', 'B', 'C') // Char -> '', String -> ""
    val a3 = doubleArrayOf(1.2, 100.345, 293.499)
    val a4 = booleanArrayOf(true, false, true)

    // Array 를 만드는 방법 (4)
    var a5 = Array(10, { 0 }) // lambda 활용한 방법
    var a6 = Array(5, {1;2;3;4;5}) // 세미콜론(;)으로 표현해야함
    a6.forEach { print(it) } // forEach 의 it 은 키워드이며 배열의 각 요소를 가르킨다.
}
