package com.example.myapplication.안드로이드_Essential

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityListViewBinding
import kotlinx.android.synthetic.main.activity_list_view.*
import org.w3c.dom.Text

class ListViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_list_view)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 아이템 리스트 준비
        val carList = ArrayList<Car>()
        for (i in 0 until 60) {
            carList.add(Car("${i + 1}" + " 번째 자동차", "${i + 1}" + " 순위 엔진"))
        }

        val adapter = ListViewAdapter(carList, layoutInflater)
        binding.listView.adapter = adapter
        
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val carName = (adapter.getItem(position) as Car).name
            val carEngine = (adapter.getItem(position) as Car).engine

            Toast.makeText(this@ListViewActivity, "$carName : $carEngine", Toast.LENGTH_SHORT).show()
        }
    }
}

class ListViewAdapter(val carForList: ArrayList<Car>, val layoutInflater: LayoutInflater) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // 그리고자하는 컨테이너
//        val layoutInflater = LayoutInflater.from(context)
//        val view = layoutInflater.inflate(R.layout.item_view, null)
//        var carNameTextView = view.findViewById<TextView>(R.id.car_name)
//        var carEngineTextView = view.findViewById<TextView>(R.id.car_engine)
//
//        carEngineTextView.text = carForList[position].name
//        carEngineTextView.text = carForList[position].engine
//
//        return view

        // 그리는 방법 2
        val view : View
        val holder: ViewHolder

        if(convertView == null) {
            Log.d("convert - 1", "1")
            view = layoutInflater.inflate(R.layout.item_view, null)
            holder = ViewHolder()
            holder.carName = view.findViewById(R.id.car_name)
            holder.carEngine = view.findViewById(R.id.car_engine)

            view.tag = holder

        } else {
            Log.d("convert - 2", "2")
            holder = convertView.tag as ViewHolder
            view = convertView
        }

        holder.carName?.text = carForList[position].name
        holder.carEngine?.text = carForList[position].engine

        return view
    }

    override fun getItem(position: Int): Any {
        // 그리고자 하는 아이템 리스트의 하나(포지션에 해당하는)
        return carForList[position]
    }

    override fun getItemId(position: Int): Long {
        // 해당 포지션의 위치해 있는 아이템 뷰의 아이디 설정
        return position.toLong()
    }

    override fun getCount(): Int {
        // 그리고자 하는 아이템 리스트의 전체 갯수
        return carForList.size
    }
}

class ViewHolder(var carName: TextView ? = null, var carEngine: TextView ? = null ) {

}