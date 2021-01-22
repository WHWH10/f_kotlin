package com.example.myapplication.안드로이드_Essential

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R

class OpenInternetSolve : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_internet_solve)
        val url = findViewById<EditText>(R.id.internet_url)
        val result = findViewById<Button>(R.id.internet_result)

        result.setOnClickListener {
            val address = url.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(address))
            startActivity(intent)
        }

        // 익명함수
        url.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                if(p0.toString() == "abcd") {
                    Log.d("Open_TRUE", "true")
                }
                Log.d("Open_After", p0.toString())
            }
                // 변하기 전, 변하고있는동안, 변한 후 숫자들 (Int)
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("Open_Before", p0.toString())
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("Open_On", p0.toString())
            }
        })
    }
}