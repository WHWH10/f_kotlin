package com.example.myapplication.kotlin

//20201106
// 22. 변수

// 변수의 접근 범위
// 1. 전역 변수 - 어디서든 접근 가능
// 2. 지역 변수 - 해당 지역에서만 접근 가능

var number100: Int = 10

fun main(array: Array<String>) {
    println(number100)

    val test = Test("홍길동")
    test.name
    test.testFun()
    println(test.name)
    println(number100)
}

class Test(var name: String) {

    fun testFun() {
        var birth: String = "2000/3/1"
        name
        number100 = 100

        fun testFun2(){
            var gender: String = "male"
        }
    }

    fun testFun2(){
        name
        // testFun 의 birth 변수 사용불가
    }
}