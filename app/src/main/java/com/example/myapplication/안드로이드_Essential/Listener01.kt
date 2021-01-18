package com.example.myapplication.안드로이드_Essential

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_listener.*

class Listener01 : AppCompatActivity() {
    var number = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        // 뷰로 액티비티를 가져오는 방법
        // 1. 직접 찾아서 가져온다
//        val textView: TextView = findViewById(R.id.hello)
        // 2. xml 을 Import (코틀린 특징)
//        hello

        // 람다 함수
        // 똑같은 함수 3개 선언 -> 마지막 함수만 호출된다 (click)
        // 1. 람다 방식
        hello.setOnClickListener {
            Log.d("Click", "Hello Click!!")
        }

        // 2. 익명함수 방식
         hello.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("Click", "Hello Click _Void")
            }
        })

        // 3. 이름이 필요한 경우(click)
        val click = object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("Click", "Hello Click _Click")
                hello.setText("안녕하세요")
                image.setImageResource(R.drawable.jin01)
                number += 10
                Log.d("number", number.toString())
            }
        }
        hello.setOnClickListener(click)

        // View 조작하는 함수
        // - setText
        // - setImageResource

//        hello.setText("안녕하세요")
//        image.setImageResource(R.drawable.jin01)


    }
}