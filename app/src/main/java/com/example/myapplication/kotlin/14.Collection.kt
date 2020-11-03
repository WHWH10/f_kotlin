package com.example.myapplication.kotlin

//20201103
// 14. Collection
// list. set. map

fun main(array: Array<String>) {

    // Immutable Collection -> 변경 불가
    // List -> 중복을 허용한다
    val numberList = listOf<Int>(1, 2, 3, 3)
    println("LIST")
    println(numberList)
    println(numberList.get(0))
    println(numberList[0])

    // Set -> 중복을 허용하지 않는다
    // 중복을 허용하지 않는다
    // 순서가 없다
    val numberSet = setOf<Int>(1, 2, 3, 3, 3)
    println()
    println("SET")
    println(numberSet)
    numberSet.forEach{println(it)}

    // Map -> Key, Value 방식으로 관리한다
    val numberMap = mapOf<String, Int>("one" to 1, "two" to 2, "three" to 3)
    println()
    println("MAP")
    println(numberMap)
    println(numberMap.get("one"))
    println()

    // Mutable Collection -> 변경가능
    val mNumberList = mutableListOf<Int>(1, 2, 3)
    println(mNumberList)
    mNumberList.add(3, 4)
    println(mNumberList)

    val mNumberSet = mutableSetOf<Int>(1, 2, 3, 4, 4, 4)
    println()
    println(mNumberSet)
    mNumberSet.add(10)
    println(mNumberSet)

    val mNumberMap = mutableMapOf<String, Int>("one" to 1)
    println()
    println(mNumberMap)
    mNumberMap.put("two", 2)
    println(mNumberMap)

    //Commit
}