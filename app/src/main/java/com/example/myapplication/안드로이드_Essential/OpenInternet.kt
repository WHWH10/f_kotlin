package com.example.myapplication.안드로이드_Essential

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.inputmethod.EditorInfo
import com.example.myapplication.databinding.ActivityOpenInternetBinding

class OpenInternet : AppCompatActivity() {
    private lateinit var binding: ActivityOpenInternetBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_open_internet)
        binding = ActivityOpenInternetBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        binding.url.addTextChangedListener(object : TextWatcher {
            // 입력 끝날 때 작동
            override fun afterTextChanged(p0: Editable?) {
//                binding.urlResult.setText(p0)
                binding.urlResult.text = p0
            }
            // 입력 전 작동
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
            // 입력 중 작동
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })

        binding.urlResult.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(binding.urlResult.text.toString()))
            startActivity(intent)
        }
    }
}