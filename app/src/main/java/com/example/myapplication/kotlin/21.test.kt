package com.example.myapplication.kotlin

//20201106
// 21. 중간과제

// 3) TV 클래스
// - on/off 기능
// - 채널을 돌리는 기능
// - 초기 채널은 (S사. M사. K사)

fun main(array: Array<String>) {
//    val channels = listOf<String>("M", "K", "S")
//    val tv = TV(channels)
    val tv = TV(listOf<String>("M", "K", "S"))
//    tv.channelUp()
//    println(tv.checkCurrentChannel())
//    tv.channelUp()
//    println(tv.checkCurrentChannel())
//    tv.channelUp()
//    println(tv.checkCurrentChannel())
//    tv.channelUp()
//    println(tv.checkCurrentChannel())
//    tv.channelUp()
//    println(tv.checkCurrentChannel())
//    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.currentChannelNumber
}

class TV(val channels: List<String>) {

    var onOnOff: Boolean = false // true -> on, false -> off
    var currentChannelNumber = 0
        // 변수가 어떤 값을 할당 받을때
        set(value) {
            // currentChannelNumber 값을 할당하는 부분
            field = value // 무한반복을 피할 수 있는 키워드 = field
            if (field > 2) {
                field = 0
            }
            if (field < 0) {
                field = 2
            }
//            currentChannelNumber = value => 스택 오버플로우 에러
        }
        // 변수가 호출될 때
        get() {
            println("호출되었습니다")
            return field
        }
    // 값의 할당
    // a = b : b 값을 a 에 할당한다


    fun switch() {
        onOnOff = !onOnOff
    }

    fun checkCurrentChannel(): String {
        return channels[currentChannelNumber]
    }

    fun channelUp() {
        currentChannelNumber = currentChannelNumber + 1
//        channels.forEachIndexed { index, value ->
//            if(currentChannelNumber == index) {
//                currentChannelNumber = currentChannelNumber + 1
//                return
//            }
//        }
    }

    fun channelDown() {
        currentChannelNumber = currentChannelNumber - 1
//        channels.forEachIndexed { index, value ->
//            if(currentChannelNumber == index) {
//                currentChannelNumber = currentChannelNumber - 1
//                return
//            }
//        }
    }
}