package com.example.myapplication.안드로이드_Essential

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityThreadBinding

class ThreadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThreadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_thread)
        binding = ActivityThreadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val runnable: Runnable = object : Runnable {
            override fun run() {
                Log.d("Thread1", "Thread is Made")
            }
        }

        val thread: Thread = Thread(runnable)

        binding.button.setOnClickListener {
            thread.start()
        }

        Thread(object: Runnable{
            override fun run() {
                Log.d("Thread2", "Thread is Made")
            }
        }).start()

        // 람다방식
        Thread(Runnable {
            Thread.sleep(2000)
            runOnUiThread {
                binding.button.setBackgroundColor(getColor(R.color.colorPrimaryDark))
            }
            Log.d("Thread3", "Thread is Made")
        }).start()

    }
}