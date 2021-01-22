package com.example.myapplication.안드로이드_Essential

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLibraryBinding

class LibraryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLibraryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_library)
        binding = ActivityLibraryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // http://bumptech.github.io/glide/doc/getting-started.html
        Glide.with(this@LibraryActivity)
            .load("https://i.pinimg.com/736x/c0/01/32/c00132b61bbac0fcdd150180aa20e90e.jpg")
            .placeholder(R.drawable.bts_logo)
            .into(binding.image)

//        Glide.with(this@LibraryActivity)
//            .load("https://i.pinimg.com/736x/c0/01/32/c00132b61bbac0fcdd150180aa20e90e.jpg")
//            .placeholder(R.drawable.bts_logo)
//            .centerCrop()
//            .into(binding.image2)

        // gif 가능
//        Glide.with(this)
//            .load("https://img.theqoo.net/proxy/http://cfile6.uf.tistory.com/image/999012495EDDC51F2E0DCE")
//            .placeholder(R.drawable.bts_logo)
//            .centerCrop()
//            .into(binding.image2)
    }
}