package com.example.myapplication.kotlin

//20201103
// 15. Collection 실습

fun main(array: Array<String>) {

    val a = mutableListOf<Int>(1, 2, 3)
    a.add(4)
    println(a)
    a.add(0, 100) // Index 없을 때 -> 맨 마지막에 추가
    println(a)
    a.set(0, 200) // 해당 Index 값 변경
    println(a)
    a.removeAt(1) // 해당 Index 값 제거
    println(a)

    val b = mutableSetOf<Int>(1, 2, 3, 4)
    println()
    println(b)
    b.add(2) // Set 순서 X -> 애초에 Index 없음
    println(b) // Set 중복 허용 X
    b.remove(2)
    println(b)
    b.remove(100) // Set 에 없는 값을 삭제해도 에러 발생 X
    println(b)

    val c = mutableMapOf<String, Int>("one" to 1)
    println()
    println(c)
    c.put("two", 2)
    println(c)
    c.replace("two", 3)
    println(c)
    println(c.keys)
    println(c.values)
    c.clear()
    println(c)
    //Commit and Push
}