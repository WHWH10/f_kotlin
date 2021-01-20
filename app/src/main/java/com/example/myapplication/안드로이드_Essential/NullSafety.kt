package com.example.myapplication.안드로이드_Essential

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R

class NullSafety : AppCompatActivity() {

    lateinit var lateCar: Car

    class Car(var number: Int) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

        val number: Int = 10
        val number1: Int? = null

        // !! -> 개발자가 Null 아님을 보장
        val number5: Int = number1!! + 10

//        val nubmer3 = number? + number1
        val number3 = number1?.plus(number)
        Log.d("Number3", "number3 : " + number3)

        // 삼항 연산자 -> 엘비스 연산자 (?:)
        // NullSafety 위한 도구
        val number4 = number1 ?: 10 // number1 이 Null 이면 10 들어가고 Null 아니면 number1 들어감
        Log.d("Number4", "number4 : " + number4)

        // LateInit 은 반드시 값을 선언하고 사용해야 한다
        lateCar = Car(100)
//        Log.d("LateInit", "late number : " + lateCar)
        Log.d("LateInit", "late number : " + lateCar.number)

    }

    fun plus(a: Int, b: Int?): Int {
        if (b != null) return a + b
        else return a
    }

    fun plus2(a: Int, b: Int?): Int? {
        return b?.plus(a)
    }
}