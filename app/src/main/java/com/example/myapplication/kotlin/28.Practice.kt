package com.example.myapplication.kotlin

//210115
// 28. 인터페이스 실습

// - 인터페이스도 구현이 있는 함수를 만들 수 있다
// - 인터페이스에 구현이 있는 함수는 그 인터페이스를 구현하는 클래스에서 그 함수를 구현할 필요가 없다
// - 인터페이스에 구현이 없는 함수는 그 인터페이스를 구현하는 클래스에서 그 함수를 반드시 구현해야한
// - abstract : 반드시 구현해야 할 함

fun main(array: Array<String>) {
    val student__ = Student__()
    student__.sleep()
    student__.eat()
}

interface Person__ {
    fun eat() {
        println("먹는다")
    }

    fun sleep() {
        println("잔다")
    }

    abstract fun study()
}

class Student__ : Person__ {
    override fun study() {
        TODO("Not yet implemented")
    }
}

class Teacher__ : Person__ {
    override fun study() {
        TODO("Not yet implemented")
    }

}