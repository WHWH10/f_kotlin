package com.example.myapplication.안드로이드_Essential

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityIntent2Binding

class Intent2 : AppCompatActivity() {
    // lateinit(느린초기화) : 초기화만 해줌 , 변수선언하면 에러남
    private lateinit var binding: ActivityIntent2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_intent2)
        binding = ActivityIntent2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.result.setOnClickListener {
            // 값이 없을때가 있으므로 기본값 작성해준다
            val number1 = intent.getIntExtra("number1", 0)
            val number2 = intent.getIntExtra("number2", 0)

            Log.d("NUMBER", number1.toString())
            Log.d("NUMBER", number2.toString())

            val result = number1 + number2

            val resultIntent = Intent()
            resultIntent.putExtra("result", result)

            // Activity.RESULT_OK = -1 : setResult(-1)
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // 액티비티 종료
        }
    }
}