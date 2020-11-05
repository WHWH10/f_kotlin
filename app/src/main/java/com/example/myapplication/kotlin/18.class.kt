package com.example.myapplication.kotlin

//20201104
// 18. 클래스

// OOP -> Object Oriented Programming (객체지향프로그래밍)

// "객체"란 뭘까?
// - 이름이 있는 모든 것

// 절차지향 프로그래밍의 문제 해결 방법
// - 코드를 위에서부터 아래로 실행을 하면 문제가 해결된다!

// 객체지향 프로그램의 문제 해결 방법
// - 객체를 만들어서, 객체에게 일을 시켜서 문제를 해결한다
// - 선수, 심판, 경기장, 관중 -> 추구 게임

// 객체를 만드는 방법
// - 설명서가 있어야 합니다

fun main(array: Array<String>) {

    // 클래스(설명서)를 통해서 실체를 만드는 방법
    // -> 인스턴스(instance): 객체
    // -> 인스턴스화 (만드는 과정)
    Car("v8 engine", "big")

    val bigCar = Car("v8 engine", "big")
    // 우리가 만든 클래스(설명서)는 자료형이 된다
    val bigCar1: Car = Car("v8 engine", "big")

    val superCar: SuperCar = SuperCar("good engine", "big", "white")

    // 인스턴스가 가지고 있는 기능을 사용하는 방법
    val runnableCar: RunnableCar = RunnableCar("simple engine", "short")
    RunnableCar("simple engine", "short").navi("대구")
    println()
    runnableCar.ride()
    runnableCar.navi("청담동")
    runnableCar.drive()

    println()

    // 인스턴스의 멤버변수에 접근하는 방법 -> 멤버변수(engine, body)
    val runnableCar2 = RunnableCar2("nice engine", "long body")
    println(runnableCar2.body)
    println(runnableCar2.engine)

    println()
    val testClass = TestClass()
    testClass.test(10)
    testClass.test(100, 200)
}

// 클래스(설명서) 만드는 방법 (1)
class Car(var engine: String, var body: String) {
}

// 클래스(설명서) 만드는 방법 (2)
class SuperCar {
    var engine: String
    var body: String
    var door: String

    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}

// 클래스(설명서) 만드는 방법 (3) -> (1) 방법의 확장
// 반드시 필요한 것 : engine, body
class Car1 constructor(engine: String, body: String) {
    // 추가적으로 필요한 부분
    var door: String = "" // inital value 설정해야 에러 안남

    // 생성자
    constructor(engine: String, body: String, door: String) : this(engine, body) { // this = Car1
        this.door = door
    }
}

// 클래스(설명서) 만드는 방법 (4) -> (2) 방법의 확장
class Car2 {
    var engine: String = ""
    var body: String = ""
    var door: String = ""

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}

// 클래스(설명서) 함수 작성 -> 기능 추가
class RunnableCar(engine: String, body: String) {

    fun ride() {
        println("탑승하였습니다")
    }

    fun drive() {
        println("달립니다 !!")
    }

    fun navi(destination: String) {
        println("${destination}(으)로 목적지가 설정되었습니다")
    }
}

class RunnableCar2 {
    var engine: String
    var body: String

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    // 클래스가 인스턴스화 될 때 가장 먼저 호출된다
    init {
        // 초기셋팅을 할 때 유용하다
        println("RunnableCar 만들어졌습니다.")
    }

    fun ride() {
        println("탑승하였습니다")
    }

    fun drive() {
        println("달립니다 !!")
    }

    fun navi(destination: String) {
        println("${destination}(으)로 목적지가 설정되었습니다")
    }
}

// 오버로딩
// - 이름이 같지만 받는 파라미터가 다른 함수
class TestClass(){

    // 함수 이름이 똑같더라도 그 함수가 받는 파라미터 부분이 다르다면 구분 할 수 있기 때문에 생성 가능
    fun test(a: Int){
        println("up :: $a")
    }

    fun test(a: Int, b: Int){
        println("down :: $a :: $b")
    }
}