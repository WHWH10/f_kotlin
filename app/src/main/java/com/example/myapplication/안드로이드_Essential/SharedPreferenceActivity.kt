package com.example.myapplication.안드로이드_Essential

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivitySharedPreferenceBinding

class SharedPreferenceActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySharedPreferenceBinding
    var isClickGet: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferenceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // SharedPreferences 저장하는 방법
//        val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
        // MODE
        // - MODE_PRIVATE : 생성한 애플리케이션에서만 사용 가능
        // - MODE_WORLD_READABLE : 다른 애플리케이션에서 사용가능 . 읽기만 가능 . 기록 불가능
        // - MODE_WORD_WRITABLE : 다른 애플리케이션에서 사용가능 . 기록 및 읽기 가능
        // - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 확인
        // - MODE_APPEND : 기존 preference 에서 신규로 추가

//        val editor: SharedPreferences.Editor = sharedPreferences.edit()
//        editor.putString("hello", "안녕하세요")
//        editor.commit()

        // sp1(SharedPreference)
        // - Key & Value : hello & 안녕하세요
        // sp2(SharedPreference)
        // - Key & Value : hello1 & 안녕하세요1

        binding.saveButton.setOnClickListener{
            val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("hello", "안녕하세요")
            editor.putString("goodBye", "안녕히가세요")
            editor.commit()
        }

        binding.resultButton.setOnClickListener {
            // SharedPreference 값을 가져오는 방법
            val sharedPreferences = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val resultValue1 = sharedPreferences.getString("hello", "데이터 없음")
            val resultValue2 = sharedPreferences.getString("goodBye", "데이터 없음")

            if (isClickGet) {

                binding.result.text = "$resultValue1 : $resultValue2"
                isClickGet = false

            } else {

                binding.result.text = ""
                isClickGet = true

            }
        }

        binding.deleteButton.setOnClickListener {
            val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.remove("hello")
            editor.commit()
        }

        binding.deleteAllButton.setOnClickListener {
            val sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.clear()
            editor.commit()
        }
    }
}