package com.example.myapplication.안드로이드_Essential

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityIntentBinding

class Intent1 : AppCompatActivity() {

    // kotlinx-extension : 안드로이드스튜디오 4.1 부터 사용하지 않음
    // viewBinding 방식 사용
    // activity_intent.xml : ActivityIntentBinding
   private lateinit var binding: ActivityIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_intent)
        binding = ActivityIntentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.changeActivity.setOnClickListener{

            // 명시적 인텐트
            // this@Intent1 = this
//            val intent = Intent(this@Intent1, Intent2::class.java)
//            val intent = Intent(this, Intent2::class.java)
            // key & value 방식 : key 와 value 를 쌍으로 만들어 저장한다 -> 딕셔너리
//            intent.putExtra("number1", 1)
//            intent.putExtra("number2", 2)
//            startActivity(intent)

//            val intent2 = Intent(this@Intent1, Intent2::class.java)
//            // apply :
//            intent2.apply {
//                this.putExtra("number1", 1)
//                this.putExtra("number2", 2)
//            }
////            startActivity(intent2)
//            // Return 받는 인텐트
//            startActivityForResult(intent2, 200)

            // 암시적 인텐트
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"))
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == 200) {
            Log.d("Request_Code", requestCode.toString())
            Log.d("Result_Code", resultCode.toString())
            val result = data?.getIntExtra("result", 0)
            Log.d("Number_Result", result.toString())
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}