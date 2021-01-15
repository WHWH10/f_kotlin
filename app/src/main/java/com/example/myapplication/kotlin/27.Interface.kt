package com.example.myapplication.kotlin

//210114
// 27. 인터페이스

// 인터페이스는 약속 -> 니가 이것을 구현하면 너도 이 타입이다
// - 생성자가 없다 -> 인스턴스화 할 수 없다
// 지침서 -> 니가 이것을 구현하고 싶다면 반드이 아래 기능을 구현해야한다

// 싱속 -> 조상을 찾아가는 느낌
// 인터페이스 -> 종의 특징

fun main(array: Array<String>) {
    val student_: Student_ = Student_()
    student_.eat()
}

interface Person_ {
    fun eat()
    fun sleep()
}

class Student_: Person_ {
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }
}

class SoccerPlayer: Person_ {
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }
}

open class Person() {
    open fun eat() {

    }

    fun sleep() {

    }
}

class Student(): Person() {
    override fun eat() {
        super.eat()
    }
}

class Teacher(): Person()  {

}