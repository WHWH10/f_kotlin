package com.example.myapplication.kotlin

//20201029
// 03. Practice

var a = 1 + 2 + 3 + 4 + 5 // 연산의 결과값을 변수에 넣어줄 수 있다.
var b = "1"
var c = b.toInt()
var d = c.toFloat()

var e = "John"
var f = "My name is $e Nice to meet you"

// Null
// - 존재하지 않는다

// var abc : Int = null
var abc1 : Int? = null // 자료형 뒤에 ? 붙으면 null 가질 수 있는 자료형으로 됨 // null 문자열 절대 아님
var abc2 : Double? = null

var g = a + 3

fun main(array: Array<String>) {
    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
    println(f)
    println(abc1)
    print(g)
}