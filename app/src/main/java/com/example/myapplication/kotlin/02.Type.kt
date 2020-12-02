package com.example.myapplication.kotlin

//20201029
// 02. Type -> 자료형

// 정수형 -> Long > Int > Short > Byte
// 실수형 -> Double > Float
// 문자 -> Char  ex) '가'
// 문자열 -> String ex)'가나다'
// 논리형(참 : True/ 거짓 : False) -> Boolean

var number = 10

// 변수 선언하는 방법2
// var/val 변수 : 자료형 = 값
var number1 : Int = 20
var hello1 : String = "HELLO"
var point1 : Double = 3.4

// Variable ? Value ?
// 1. 변하지 않는 값이라면 Value
// 2. 진짜 모르겠다 !(변할지 안변할지) Value : 값을 바꿀일이 생겼을 경우 Variable 로 바꾸면 가능

fun main(array:Array<String>){
    number = 20
}