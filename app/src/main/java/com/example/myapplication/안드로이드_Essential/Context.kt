package com.example.myapplication.안드로이드_Essential

import android.app.Application
import android.os.Binder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityContextBinding

class Context: AppCompatActivity() {
    private lateinit var binding: ActivityContextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContextBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val context: Context = this
        val applicationContext: Context = getApplicationContext() as Context
    }
}