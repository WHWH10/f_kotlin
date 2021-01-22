 package com.example.myapplication.안드로이드_Essential

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityPhoneBookDetailSolveBinding

class PhoneBookDetailSolveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhoneBookDetailSolveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_phone_book_detail_solve)
        binding = ActivityPhoneBookDetailSolveBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getPersonInfoAndDraw()

        binding.back.setOnClickListener {
            onBackPressed()
        }
    }

    fun getPersonInfoAndDraw() {
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")

        binding.personDetailName.text = name
        binding.personDetailNumber.text = number
    }
}