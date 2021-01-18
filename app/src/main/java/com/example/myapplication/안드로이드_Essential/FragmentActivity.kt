package com.example.myapplication.안드로이드_Essential

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.example.myapplication.R

class FragmentActivity : AppCompatActivity(), FragmentOne.OnDataPassListener {

    // interface 함수는 무조건 구현해줘야 함
    override fun onDataPass(data: String?) {
        Log.d("life_cycle_pass", "" + data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        Log.d("life_cycle", "onCreate")

        val fragmentOne: FragmentOne = FragmentOne()

        // Fragment 데이터 넣어주는 방법
        // - bundle
        val bundle = Bundle()
        bundle.putString("hello", "hello")
        fragmentOne.arguments = bundle

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            // Fragment 동적으로 작동하는 방법
            val fragmentManager: FragmentManager = supportFragmentManager

            // transaction : 작업의 단위 (시작과 끝이 있다)
            // 시작
            val fragmentTransaction = fragmentManager.beginTransaction()
            // 중간(처리과정)
            // - replace
            // - add
            fragmentTransaction.replace(R.id.container, fragmentOne)
            //끝을 내는 방법
            // - commit -> 시간날때 해 , 좀 더 안정적임
            // - commitNow -> 지금당장해
            fragmentTransaction.commit()
//            fragmentTransaction.commitNow()
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
//            val fragmentOne: FragmentOne = FragmentOne()
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            // - detach
            // - remove
//            fragmentTransaction.detach(fragmentOne)
            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle", "onDestroy")
    }
}