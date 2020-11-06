package com.example.myapplication.kotlin

//20201106
// 20. 중간과제

// 2) 이행 계좌 들기
// - 계좌 생성 기능 (이름, 생년월일, 초기금액)
// - 잔고를 확인하는 기능
// - 출금 기능
// - 예금 기능

fun main(array: Array<String>) {

    val account: Account = Account("홍길동", "1990/3/1", 1000)
    println(account.checkBalance())
    println(account.deposit(1000))
    println(account.withdraw(2000))
    println(account.checkBalance())
    println()

    val account2: Account = Account("홍길동", "1990/3/1", -2000)
    println(account2.checkBalance())
    println()

    val account3: Account2 = Account2("홍길동", "1990/3/1")
    val account4: Account2 = Account2("홍길동", "1990/3/1", 4000)
    println(account3.checkBalance())
    println(account4.checkBalance())
    println()

    val account5: Account3 = Account3(3000)
    val account6: Account3 = Account3(-20109)
    println(account5.checkBalance())
    println(account6.checkBalance())

}

class Account {
    val name: String
    val birth: String
    var balance: Int

    constructor(name: String, birth: String, balance: Int) {
        this.name = name
        this.birth = birth
        if (balance >= 0) {
            this.balance = balance
        } else {
            this.balance = 0
        }
    }

    // 잔고를 확인하는 기능
    fun checkBalance(): Int {
        return balance
    }

    // 출금기능
    fun withdraw(amount: Int): Boolean {
        if (balance >= amount) {
            balance -= amount
            return true
        }
        return false
    }

    // 예금기능
    fun deposit(amount: Int) {
        balance += amount
    }
}

// balance 없으면 1000 있으면 balance 값
class Account2(val name: String, val birth: String, var balance: Int = 1000) {

    // 잔고를 확인하는 기능
    fun checkBalance(): Int {
        return balance
    }

    // 출금기능
    fun withdraw(amount: Int): Boolean {
        if (balance >= amount) {
            balance -= amount
            return true
        }
        return false
    }

    // 예금기능
    fun deposit(amount: Int) {
        balance += amount
    }
}

// Account2 의 또다른 방법
class Account3(initialBalance: Int) {

    val balance: Int = if(initialBalance >= 0) initialBalance else 0

    fun checkBalance(): Int {
        return balance
    }
}
