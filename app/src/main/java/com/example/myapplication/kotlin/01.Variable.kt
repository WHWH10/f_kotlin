package com.example.myapplication.kotlin

//20201029
// 01. Variable -> 변수

// 변수 선언하는 방법
// var/val 변수명(상자) = 값(넣고싶은 것)
// Variable : 내 마음대로 원하는 것을 넣을 수 있음
// Value : 한번 넣으면 바꿀 수 없

var num = 10
var hello = "HELLO"
var point = 3.4

val fix = 20

fun main(args:Array<String>){
    println(num)
    println(hello)
    println(point)
    println(fix)

    num = 100
    hello = "GOOD BYE"
    point = 10.4

    println(num)
    println(hello)
    println(point)
    println(fix)

}