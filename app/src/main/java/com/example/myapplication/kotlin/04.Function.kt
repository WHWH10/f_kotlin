package com.example.myapplication.kotlin

//20201029
// 04. Function -> 함수
// 어떤 입력값을 넣어주면 어떤 출력값이 나오는 것
// ex) y = x + 2

// 함수를 선언하는 방법
// fun 함수명 (변수명 : 타입, 변수명 : 타입 ...) : 반환형 {
//      함수내용
//      return 반환값
// }

fun plus(first: Int, second: Int): Int {
//    println(first)
//    println(second)

    val result: Int = first + second

//    println(result)

    return result
}

//20201029
// 05. Function => 함수2

// 디폴트 값을 갖는 함수 만들기
fun plusFive(first: Int, second: Int = 5): Int {
    val result: Int = first + second

    return result
}

// 반환값이 없는 함수 만들기
fun printPlus(first: Int, second: Int): Unit {
    val result: Int = first + second
    println(result)
    // Unit -> 아무것도 return 하지 않겠다 (Unit 생략가능)
}

// 반환값이 없는 함수 만들기2
fun printPlus2(first: Int, second: Int) {
    val result: Int = first + second
    println(result)
}

// 간단하게 함수를 선언하는 방법
fun plusShort(first: Int, second: Int) = first + second

// 가변인자를 갖는 함수를 선언하는 방법
fun plusMany(vararg numbers: Int) {
    for(number in numbers){
        println(number)
    }
}

fun main(array: Array<String>) {
    // 함수를 호출하는 방법
    val result = plus(10, 20)
    println(result)

    // 인수를 명시적으로 전달하는 방법
    val result2 = plus(first = 20, second = 40)
    println(result2)

    val result3 = plus(second = 30, first = 10)
    println(result3)

    // 디폴트 값을 갖는 함수 호출하기
    println()
    val result4 = plusFive(10, 20)
    println(result4)

    val result5 = plusFive(10)
    println(result5)

    val result6 = plusFive(first = 3)
    println(result6)

    // 반환값이 없는 함수
    println()
    printPlus(20, 20)

    // 간단한 함수
    println()
    val result7 = plusShort(50, 50)
    println(result7)

    // 가변인자
    println()
    plusMany(1,2,3)
    plusMany(1,2,3,4,100)
}