package com.example.myapplication.안드로이드_Essential

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAddViewBinding

class AddViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_view)
        binding = ActivityAddViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 아이템 리스트 준비
        val carList = ArrayList<Car>()
        for (i in 0 until 10) {
            carList.add(Car("" + i + " 번째 자동차", "" + i + " 순위 엔진"))
        }

        val container = binding.addViewContainer
//        val inflater = this@AddViewActivity.layoutInflater
        val inflater = LayoutInflater.from(this@AddViewActivity)
        for (i in 0 until carList.size) {
            val itemView = inflater.inflate(R.layout.item_view, null)
            val carNameView = itemView.findViewById<TextView>(R.id.car_name)
            val carEngineView = itemView.findViewById<TextView>(R.id.car_engine)

            carNameView.setText(carList.get(i).name)
            carEngineView.text = carList[i].engine
            container.addView(itemView)
        }
    }
}

class Car(val name: String, val engine: String) {

}