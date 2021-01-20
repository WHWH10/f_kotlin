package com.example.myapplication.안드로이드_Essential

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.get
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityPhoneBookBinding

//class PhoneBookActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityPhoneBookBinding
//
//    @SuppressLint("ResourceType")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_phone_book)
//        binding = ActivityPhoneBookBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//
//        // 아이템 리스트 준비
//        val phoneList = ArrayList<Phone>()
//        val imageUrl: Array<String> = resources.getStringArray(R.array.jin_url)
//        for (i in 0 until 10) {
//            phoneList.add(Phone("" + i + " 번째 사람", "010-$i$i$i$i-${i + 1}${i + 1}${i + 1}${i + 1}",imageUrl[i]))
//        }
//
//        val container = binding.phoneContainer
//        val inflater = LayoutInflater.from(this@PhoneBookActivity)
//        for (i in 0 until phoneList.size) {
//            val itemView = inflater.inflate(R.layout.phone_book_item, null)
//            val phoneName = itemView.findViewById<TextView>(R.id.phone_name)
//
//            phoneName.text = phoneList[i].name
//
//            val phoneDetail = itemView.findViewById<LinearLayout>(R.id.item_container)
//            phoneDetail.setOnClickListener {
//                val intent = Intent(this@PhoneBookActivity, PhoneBookDetailActivity::class.java)
//                intent.apply {
//                    putExtra("name", phoneList[i].name)
//                    putExtra("phoneNumber", phoneList[i].phoneNumber)
//                    putExtra("imageUrl", imageUrl[i])
//                }
//                startActivity(intent)
//            }
//            container.addView(itemView)
//        }
//    }
//}

class Phone(val name: String, val phoneNumber: String, val imageUrl: String) {

}

class PhoneList() {
    val phoneList = ArrayList<Phone>()

    fun addPhoneList(phone: Phone) {
        phoneList.add(phone)
    }
}

// 해설 강의 듣고 정리

class PhoneBookActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhoneBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneBookBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val phone = createPhone()
        createPhoneList(phone)
    }

    fun createPhone(number: Int = 10, phoneList: PhoneList = PhoneList()): PhoneList {
        val imageUrl = resources.getStringArray(R.array.jin_url)
        for (i in 0 until number) {
            phoneList.addPhoneList(
                Phone(
                    "${i+1}"+ " 번째 사람",
                    "010-$i$i$i$i-${i + 1}${i + 1}${i + 1}${i + 1}",
                    imageUrl[i]
                )
            )
        }
        return phoneList
    }

    fun createPhoneList(phone: PhoneList) {
        val inflater = LayoutInflater.from(this@PhoneBookActivity)
        val container = binding.phoneContainer
        for (i in 0 until phone.phoneList.size) {
            val itemView = inflater.inflate(R.layout.phone_book_item, null)
            val phoneName = itemView.findViewById<TextView>(R.id.phone_name)

            phoneName.text = phone.phoneList[i].name

            addSetOnClickListener(phone.phoneList[i], itemView)
            container.addView(itemView)
        }
    }

    fun addSetOnClickListener(phone: Phone, view: View) {
        view.setOnClickListener {
            val intent = Intent(this@PhoneBookActivity, PhoneBookDetailActivity::class.java)
            intent.apply {
                putExtra("name", phone.name)
                putExtra("phoneNumber", phone.phoneNumber)
                putExtra("imageUrl", phone.imageUrl)
            }
            startActivity(intent)
        }
    }
}