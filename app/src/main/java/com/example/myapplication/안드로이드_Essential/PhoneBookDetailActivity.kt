package com.example.myapplication.안드로이드_Essential

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityPhoneBookDetailBinding

class PhoneBookDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhoneBookDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_phone_book_detail)
        binding = ActivityPhoneBookDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("phoneNumber")
        val url = intent.getStringExtra("imageUrl")

        Glide.with(this@PhoneBookDetailActivity)
            .load(url)
            .fitCenter()
            .into(binding.detailImage)

        binding.detailName.text = name
        binding.detailNumber.text = number
        binding.detailCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
            startActivity(intent)
        }

    }
}