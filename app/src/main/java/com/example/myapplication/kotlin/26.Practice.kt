package com.example.myapplication.kotlin

//210114
// 26. 상속과제

// Night, Monster (부모클래스) : 24.practice.kt -> Character 생성
// SuperNight, SuperMonster (자식클래스)

fun main(array: Array<String>) {
    val monster: SuperMonster = SuperMonster(100, 10)
    val night: SuperNight = SuperNight(130, 8)

    monster.attack(night)
    monster.bite(night)
}

// 상속 특징
// - 자식 클래스는 부모 클래스의 타입
// ex) SuperNight 타입은 Character 타입이기도 함
// - 부모 클래스는 자식 클래스의 타입이 아니다
open class Character(var hp: Int, val power: Int) {
    fun attack(character: Character, power: Int = this.power) {
        // power 인자를 superNight 에서는 쓰지 않을수도 있음
        // power 기본값을 할당해준다 -> power 없을때는 기본값 호출
        character.defense(power)
    }

    open fun defense(damage: Int) {
        hp -= damage
        // javaClass.simpleName: 클래스명
        if(hp > 0) println("${javaClass.simpleName} 남은 체력 $hp")
        else println("사망했습니다")
    }
}

// 자식 클래스가 인스턴스화 되기 위해서는 부모 클래스 선행되서 인스턴스화 되어야 한다.
// 부모로 넘어가는 변수는 var, val 둘다 적지 않아야한다. -> 부모에서 이미 생성 & 자식에서 변수 바꿈을 피하기 위함
class SuperNight(hp: Int, power: Int): Character(hp, power) {
    val defensePower = 2

    override fun defense(damage: Int) {
        super.defense(damage-defensePower)
    }
}

class SuperMonster(hp: Int, power: Int): Character(hp, power) {
    fun bite(character: Character) {
        super.attack(character, power+2)
    }
}


