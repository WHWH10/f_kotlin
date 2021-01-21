package com.example.myapplication.안드로이드_Essential

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityPhoneBookRecyclerViewBinding

class PhoneBookRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhoneBookRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_phone_book_recycler_view)
        binding = ActivityPhoneBookRecyclerViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        // 아이템 리스트 준비
//        val phoneList = ArrayList<Phone>()
//        val imageUrl: Array<String> = resources.getStringArray(R.array.jin_url)
//        for (i in 0 until 10) {
//            phoneList.add(
//                Phone(
//                    "" + i + " 번째 사람",
//                    "010-$i$i$i$i-${i + 1}${i + 1}${i + 1}${i + 1}",
//                    imageUrl[i]
//                )
//            )
//        }
//
//        val recyclerViewAdapter = PhoneRecyclerAdapter(phoneList, layoutInflater, this@PhoneBookRecyclerViewActivity)
//        binding.recyclerView.adapter = recyclerViewAdapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(this@PhoneBookRecyclerViewActivity)

        // 2. 변수 관리 필요없게 만들어 봅시다
//        val recyclerViewAdapter =
//            PhoneRecyclerAdapter(
//                itemList = createPhone(),
//                layoutInflater = layoutInflater,
//                context = this@PhoneBookRecyclerViewActivity
//            )
//        with(binding.recyclerView) {
//            this.adapter = recyclerViewAdapter
//            this.layoutManager = LinearLayoutManager(this@PhoneBookRecyclerViewActivity)
//        }

        // 3. 더 간단한 방법
        with(binding.recyclerView) {
            this.adapter = PhoneRecyclerAdapter(
                itemList = createPhone(),
                layoutInflater = LayoutInflater.from(this@PhoneBookRecyclerViewActivity),
                context = this@PhoneBookRecyclerViewActivity
            )
            this.layoutManager = LinearLayoutManager(this@PhoneBookRecyclerViewActivity)
        }
    }

    fun createPhone(number: Int = 10): ArrayList<Phone> {
        // 파라미터로 ArrayList<Phone>() 받을 때 초기화 = arrayListOf<Phone>(Phone("", "", ""))
        val phoneList = ArrayList<Phone>()
        val imageUrl = resources.getStringArray(R.array.jin_url)
        for (i in 0 until number) {
            phoneList.add(
                Phone(
                    "${i + 1}" + " 번째 사람",
                    "010-$i$i$i$i-${i + 1}${i + 1}${i + 1}${i + 1}",
                    imageUrl[i]
                )
            )
        }
        return phoneList
    }
}

class PhoneRecyclerAdapter(
    val itemList: ArrayList<Phone>,
    val layoutInflater: LayoutInflater,
    val context: PhoneBookRecyclerViewActivity
) : RecyclerView.Adapter<PhoneRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val phoneName: TextView

        init {
            phoneName = itemView.findViewById(R.id.phone_name)
            itemView.setOnClickListener {
                val position = adapterPosition
                val imageUrl: Array<String> = context.resources.getStringArray(R.array.jin_url)
                val intent = Intent(context, PhoneBookDetailActivity::class.java)
                intent.putExtra("name", itemList[position].name)
                intent.putExtra("phoneNumber", itemList[position].phoneNumber)
                intent.putExtra("imageUrl", imageUrl[position])
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.phone_book_item_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.phoneName.text = itemList[position].name
    }

}
