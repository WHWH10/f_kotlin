package com.example.myapplication.안드로이드_Essential

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityResourceBinding
import kotlinx.android.synthetic.main.activity_listener.view.*

class Resource: AppCompatActivity() {
    private lateinit var binding: ActivityResourceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResourceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 방법 1
        val ment = resources.getString(R.string.hello)
        Log.d("MENT", ment)

        // 방법 2
        val ment2 = getString(R.string.hello)
        Log.d("MENT_2", ment)

        val color = getColor(R.color.textView_color)
        Log.d("MENT_COLOR", color.toString())

        // SDK 버전에 따른 분기 처리
        val color2 = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getColor(R.color.textView_color)
        } else {
            resources.getColor(R.color.textView_color)
        }

        binding.button.setOnClickListener{

            binding.button.setBackgroundColor(getColor(R.color.colorAccent))
        }
    }
}