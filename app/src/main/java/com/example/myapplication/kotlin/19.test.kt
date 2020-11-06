package com.example.myapplication.kotlin

//20201105 ~ 20201106
// 19. 클래스 중간과제 (풀이)

// 1) 사칙연산을 수행 할 수 있는 클래스
class Operator {
    var a: Int
    var b: Int

    constructor(a: Int, b: Int) {
        this.a = a
        this.b = b
    }

    fun sum(): Int {
        return a + b
    }

    fun minus(): Int {
        return a - b
    }

    fun multiply(): Int {
        return a * b
    }

    fun divide(): Int {
        return a / b
    }

}

class Calculator1() {
    fun plus(a: Int, b: Int): Int {
        return a + b
    }

    fun minus(a: Int, b: Int): Int {
        // 먼저 들어온 수에서 뒤에 들어온 수를 뺀다
        return a - b
    }

    fun multiple(a: Int, b: Int): Int {
        return a * b
    }

    fun divide(a: Int, b: Int): Int {
        // 먼저 들어온 수에서 뒤에 들어온 수를 나눈다
        // 몫마 취한다
        return a / b
    }
}

// 여러개 숫자를 받아서 사용 할 수 있음
class Calculator2() {
    // vararg : 가변인자를 갖는 함수 선언하는 방법
    fun plus(vararg numbers: Int): Int { // 1, 2, 3...
        var result = 0
        numbers.forEach {
//            result = result + it
            result += it
        }
        return result
    }

    fun minus(vararg numbers: Int): Int { // 10, 1, 2, 3
//        var result = 0 // 0 - 10 - 1 - 2- 3
        var result = numbers[0]
        for (i in 0 until numbers.size) {
//            result -= numbers[i]
//            result = result - numbers[i]
            if (i != 0) {
                result = result - numbers[i]
            }
        }
        return result
    }

    fun multiple(vararg numbers: Int): Int {
        var result: Int = 1
        numbers.forEach {
            if (it != 0) {
                result = result * it
            }
        }
        return result
    }

    fun divide(vararg numbers: Int): Int { // 10, 2, 3
        var result: Int = numbers[0]
        numbers.forEachIndexed { index, value ->
            // result 에 이미 첫번째 변수(10)가 있으므로 2가 들어와야한다
            // 10/10/2/3
            // 첫번째 index 를 건너뛰어야한다.
//            if(index != 0) {
//                if(value != 0 ) {
//                    result = result / value
//                }
//            }
            if (index != 0 && value != 0) {
                result = result / value
            }
        }
        return result
    }
}

class Calculator3(val initialValue: Int) {

    fun plus(number: Int): Calculator3 {
        val result = this.initialValue + number
        return Calculator3(result)
    }

    fun minus(number: Int): Calculator3 {
        val result = this.initialValue - number
        return Calculator3(result)
    }

    fun multiple(number: Int): Calculator3 {
        val result = this.initialValue * number
        return Calculator3(result)
    }

    fun divide(number: Int): Calculator3 {
        val result = this.initialValue / number
        return Calculator3(result)
    }
}

// 2) 이행 계좌 만들기
// - 계좌 생성 기능 (이름, 생년월일)
// - 잔고를 확인하는 기능
// - 출금 기능
// - 예금 기능

class BankAccount {
    var balance: Int = 0

    fun makeAccount(name: String, birth: String) {
        println("${name}(${birth})의 계좌생성을 축하드립니다.")
    }

    fun checkBalance(password: String) {
        if (password == "") {
            balance = 2000
            println("잔고는 $balance 원 입니다.")
        } else {
            balance = 0
            println("잔고는 $balance 원 입니다.")
        }
    }

    fun withdraw(money: Int) {
        if (balance > money) {
            println("${money}원 출금하시겠습니까?")
        } else {
            println("잔고가 부족합니다.")
        }
    }

    fun deposit() {
        println("예금기능입니다.")
    }
}

// 3) TV 클래스
// - on/off 기능
// - 채널을 돌리는 기능
// - 초기 채널은 (S사. M사. K사)
class TVClass {
    var channel1: String
    var channel2: String
    var channel3: String

    constructor() {

    }

    constructor(channel1: String, channel2: String, channel3: String) {
        this.channel1 = channel1
        this.channel2 = channel2
        this.channel3 = channel3
    }

    init {
        channel1 = "MBC"
        channel2 = "KBS"
        channel3 = "SBS"
        println(channel1)
        println(channel2)
        println(channel3)
    }

    fun power(power: Boolean): String {
        if (power) {
            return "티비가 켜졌습니다."
        } else {
            return "티비가 꺼졌습니다."
        }
    }

    fun changeChannel(channel: Int): String {
        var initChannel: Int = 0;

        if (initChannel == channel) {
            return "현재 채널과 동일합니다."
        } else {
            initChannel = channel
            return "${initChannel}로 채널이 변경되었습니다."
        }
    }
}

fun main(array: Array<String>) {
//    val operator = Operator(12, 4)
//    println(operator.sum())
//    println(operator.minus())
//    println(operator.multiply())
//    println(operator.divide())

    val calculator1 = Calculator1()
    println("첫번째 계산기")
    println(calculator1.plus(30, 20))
    println(calculator1.minus(30, 20))
    println(calculator1.multiple(30, 20))
    println(calculator1.divide(30, 20))
    println()

    val calculator2 = Calculator2()
    println("두번째 계산기")
    println(calculator2.plus(1, 2, 3, 4))
    println(calculator2.minus(10, 1, 2, 3))
    println(calculator2.multiple(1, 2, 3))
    println(calculator2.divide(10, 2, 3))
    println()

    val calculator3 = Calculator3(3)
    println("세번째 계산기")
    calculator3.plus(5).minus(5)
    // --------/ -> calculator3(3)
    // -----------------------/ -> calculator3(8)
    // ----------------------------------------/ -> calculator3(8).minus(5)
    // Calculator3 를 return 했기 때문에 Calculator3 의 기능을 쓸 수 있다
    // 자기 자신 클래스를 리턴해서 기능을 이어나가는 것 -> Chaining(체이닝)

//
//    println()
//
//    val bankAccount = BankAccount()
//    bankAccount.makeAccount("로제", "001010")
//    bankAccount.checkBalance("1234")
//    bankAccount.deposit()
//    bankAccount.withdraw(30000)
//
//    println()
//
//    val tvClass = TVClass()
//    println(tvClass.power(true))
//    println(tvClass.power(false))
//    println(tvClass.changeChannel(0))
//    println(tvClass.changeChannel(34))
}