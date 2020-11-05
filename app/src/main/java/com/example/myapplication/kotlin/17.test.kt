package com.example.myapplication.kotlin

//20201105
// 17. 중간과제

// 1)
// List 를 두개 만든다
// 첫번째 List 에는 0부터 9까지 값을 넣는다(반복문 사용)
// 두번째 List 에는 첫번째 ArrayList 값을 하나씩 확인 한 후
// 짝수면 True. 홀수면 False

fun first() {
    val one = mutableListOf<Int>()
    for (i in 0..9) {
        one.add(i, i)
    }
    println(one)

    val two = mutableListOf<Boolean>()
    for (item in one) {
        if (one.get(item) % 2 == 0) {
            two.add(true)
        } else {
            two.add(false)
        }
    }
    println(two)
    println()
}

fun first_solve() {
    val list1 = MutableList(9, { 0 })
    val list2 = MutableList(9, { true })

    for (i in 0..8) {
        list1[i] = i + 1
    }
    println(list1)

//    for(i in 1..9) {
//        list1[i-1] = i
//    }
//    println(list1)

    list1.forEachIndexed { index, value ->
        if (value % 2 == 0) {
            // 짝수
            list2[index] = true
        } else {
            // 홀수
            list2[index] = false
        }
        // list2[index] = value % 2 == 0
    }
    println(list2)
    println()
}

// 2)
// 학점을 구하자
// 80 - 90 -> A
// 70 - 79 -> B
// 60 - 69 -> C
// 나머지 F

fun second(grade: Int): String {
    if (grade in 80..90) {
        return "A"
    } else if (grade in 70..80) {
        return "B"
    } else if (grade in 60..70) {
        return "C"
    } else {
        return "F"
    }
    println()
}

fun second_solve(score: Int): String {
    var result: String = "F"

    when (score) {
        in 90..100 -> {
            result = "A"
        }
        in 80..90 -> {
            result = "B"
        }
        in 70..80 -> {
            result = "C"
        }
    }
    return result

//    when(score) {
//        in 90..100 -> {
//            return "A"
//        }
//        in 80..89 -> {
//            return "B"
//        }
//        in 70..79 -> {
//            return "C"
//        }
//        else -> {
//            return "F"
//        }
//    }
}

// 3)
// 전달 받은 숫자의 각 자리 숫자의 합을 구하라
// 조건 : 전달 받은 숫자는 무조건 두자리 숫자이다

fun third(value: Int): Unit {
    var sum: Int = 0;
    if (value in 11..99) {
        var a: Int = value / 10
        var b: Int = value % 10
        sum = a + b
        println(sum)
    } else {
        print("숫자 다시 입력")
    }
    println()
}

fun third_solve(number: Int): Int {
    // ex) 89
    val a: Int = number / 10 // 8 (몫)
    val b: Int = number % 10 // 9 (나머지)

    return a + b
}

// 4)
// 구구단을 출력하자
fun gugudan() {
    for (item in 1..9) {
        for (value in 1..9) {
            val result = item * value
            println("$item" + " * " + "$value" + " = " + result)
        }
    }
}

fun gugudan_solve() {
    for (x in 1..9) {
        // 1 -> 2 -> ...
        for (y in 1..9) {
            // 1 부터 9 까지 반복 -> 1 부터 9 까지 반복 -> ...
            println("$x * $y = ${x*y}")
        }
    }
}

fun main(array: Array<String>) {
//    first()
    first_solve()
//    println(second(10))
    println(second_solve(10))
    println()
//    println(third(34))
    println(third_solve(89))
    println()
//    gugudan()
    println(gugudan_solve())
}