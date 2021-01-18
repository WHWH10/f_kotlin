package com.example.myapplication.안드로이드_Essential

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_calculator02.*

class Calculator02 : AppCompatActivity() {
    var old: String  = ""
    var new: String = ""
    var number: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator02)

        reset.setOnClickListener {
            result.text = "0"
        }

        plus.setOnClickListener{
            if(old == "") {
                old = "0"
            }
            Log.d("Calculator_new", new)
            Log.d("Calculator_old", old)
            number = (old.toInt() + new.toInt()).toString()
            Log.d("Calculator", "${old.toInt() + new.toInt()}")
            new = ""
        }

        equal.setOnClickListener{
            result.text = number
        }

        num1.setOnClickListener {
            new += "1"
            result.setText(new)
        }

        num2.setOnClickListener {
            new += "2"
            result.text = new
        }

        num3.setOnClickListener{
            new += "3"
            result.text = new
        }

        num4.setOnClickListener{
            new += "4"
            result.text = new
        }

        num5.setOnClickListener{
            new += "5"
            result.text = new
        }

        num6.setOnClickListener{
            new += "6"
            result.text = new
        }

        num7.setOnClickListener{
            new += "7"
            result.text = new
        }

        num8.setOnClickListener{
            new +="8"
            result.text = new
        }

        num9.setOnClickListener{
            new += "9"
            result.text = new
        }

        num0.setOnClickListener{
            new+= "0"
            result.text = new
        }
    }
}