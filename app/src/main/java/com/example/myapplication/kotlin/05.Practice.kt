package com.example.myapplication.kotlin

//20201029
// 05. Function -> 실습

fun plusThree(first: Int, second: Int, third: Int): Int {
//    val result = first + second + third
//    return result
    return first + second + third
}

fun minusThree(first: Int, second: Int, third: Int) = first - second - third

fun multipleThree(first: Int = 1, second: Int = 1, third: Int = 1): Int{
    return first * second * third
}

// 내부 함수(함수 안에 함수가 들어 있는 것)
fun showMyPlus(first: Int, second: Int): Int{
    println(first)
    println(second)

    fun plus(first: Int, second: Int): Int{
        return first + second
    }

    return plus(first, second)
}

fun main(array: Array<String>) {
    val result = plusThree(1, 2,3)
    println(result)

    val result2 = minusThree(10, 1, 1)
    println(result2)

    val result3 = multipleThree(2, 2, 2)
    println(result3)

    val result4 = multipleThree()
    println(result4)

    // 함수 안에 함수
    println()
    val result5 = showMyPlus(10, 5)
    println(result5)
}