package com.example.myapplication.kotlin

//210114
// 25. 상속

// 두번까지는 봐준다
// 두번이상 넘어가면 리팩토링한다

// 상속 -> 부모로부터 설명서를 물려받는다

// class Car100 = private class Car100 : private 쓰지 않아도 기본으로 설정되어있음

fun main(array: Array<String>) {
    val superCar100: SuperCar100 = SuperCar100()
//    superCar100.drive()
    println(superCar100.drive())
    superCar100.stop()
}

// 상속은 외부에서 접근할수 있어야 하므로 키워드 open 사용
// 부모: Car100
// 자식 : SuperCar100, Bus100
open class Car100() {
    // override 함수로 사용하기 위해선 open 키워드 사용
    open fun drive(): String {
//        println("달린다")
        return "달린다"
    }

    fun stop() {

    }
}

// Generate Method 단축키 : command + N
class SuperCar100(): Car100() {
    override fun drive(): String {
//        super.drive() // 부모의 기능을 return 하는 부분
//        println("빨리 달린다")
        // 부모로부터 "달린다" 상속받음
        val run = super.drive()
        return "빨리 $run"
    }
}

class Bus100(): Car100() {

}
