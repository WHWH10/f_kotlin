package com.example.myapplication.안드로이드_Essential

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_recycler_view)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 아이템 리스트 준비
        val carList = ArrayList<Car>()
        for (i in 0 until 60) {
            carList.add(Car("${i + 1}" + " 번째 자동차", "${i + 1}" + " 순위 엔진"))
        }

        val recyclerViewAdapter = RecyclerViewAdapter(carList, LayoutInflater.from(this@RecyclerViewActivity))
        binding.recyclerView.adapter = recyclerViewAdapter

//        binding.recyclerView.layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
        binding.recyclerView.layoutManager = GridLayoutManager(this@RecyclerViewActivity, 2)
    }
}

class RecyclerViewAdapter(val itemList: ArrayList<Car>, val inflater: LayoutInflater): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val carName: TextView
        val carEngine: TextView

        // 초기화
        init {
            carName = itemView.findViewById(R.id.car_name)
            carEngine  = itemView.findViewById(R.id.car_engine)
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                val carName = itemList[position].name

                Log.d("CarName", carName)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carName.text = itemList[position].name
        holder.carEngine.text = itemList[position].engine
    }
}