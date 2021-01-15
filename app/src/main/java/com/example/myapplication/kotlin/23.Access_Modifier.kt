package com.example.myapplication.kotlin

//20210114
// 23. 접근제어자

// private : 외부에서 사용할 수 없

fun main(array: Array<String>) {
    val testAccess: TestAccess = TestAccess("아무개")
    testAccess.test()
    println(testAccess.name)
    testAccess.name = "아무개2"
    println(testAccess.name)

    val reward: Reward = Reward()
    // private 함수이므로 외부에서 사용 불가
//    reward.chaneRewardAmount(2000)

    val runningCar: RunningCar = RunningCar()
    runningCar.runFast()
//    runningCar.run()

}

class RunningCar() {

    fun runFast() {
        run()
    }

    private fun run() {

    }
}

class Reward() {
    // 외부에서 접근할 수 없는 변수가 됨
    private var rewardAmount: Int = 1000

//    constructor(rewardAmount: Int) {
//        this.rewardAmount = rewardAmount
//    }

    private fun chaneRewardAmount(newRewardAmount: Int) {
        rewardAmount = newRewardAmount
        print("$rewardAmount --- $newRewardAmount")
    }
}

class TestAccess {
    var name: String = "홍길동"

    constructor(name: String) {
        this.name = name
    }

    fun test() {
        println("테스트")
    }

}