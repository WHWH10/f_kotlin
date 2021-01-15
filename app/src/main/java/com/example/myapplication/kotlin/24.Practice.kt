package com.example.myapplication.kotlin

//20210114
// 24. 접근제어자 실습

fun main(array: Array<String>) {
    val night = Night(20, 4)
    val monster = Monster(15, 5)

    night.attack(monster)
    monster.attack(night)

}

class Night(private var hp: Int, private var power: Int) {

    fun attack(monster: Monster) {
        monster.defense(power)
    }

    fun defense(damage: Int) {
        hp -= damage

        if(hp > 0) {
            heal()
            println("기사 현재 체력은 $hp 입니다.")
        }
        else println("기가 죽었습니다.")

    }

    private fun heal() {
        // 공격을 당했는데 죽지않았을때만 호출하는 함수
        // 외부에서 쓰지 않는 함수
        // 클래스 내에서만 사용하므로 private
        hp += 3
    }
}

// 외부에서 변경 불가능한 변수
// 외부에서 접근할 수 없는 변수
class Monster2(private val hp: Int, private val power: Int) {
    private fun attack() {

    }
}

class Monster(private var hp: Int, private var power: Int) {

    fun attack(night: Night) {

        night.defense(power)
    }

    fun defense(damage: Int) {
        hp -= damage

        if(hp > 0) println("몬스터 현재 체력은 $hp 입니다.")
        else println("몬스터가 죽었습니다.")
    }
}