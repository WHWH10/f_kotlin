package com.example.myapplication.안드로이드_Essential

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityPhoneBookSolveBinding

class PhoneBookSolveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhoneBookSolveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_phone_book_solve)
        binding = ActivityPhoneBookSolveBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val phoneBookSolve = createFakePhoneBook(30)
        createFakePhoneBookList(phoneBookSolve)
    }

    fun createFakePhoneBook(
        fakeNumber: Int = 10,
        phoneBookSolve: PhoneBookSolve = PhoneBookSolve()
    ): PhoneBookSolve {
        for (i in 0 until fakeNumber) {
            phoneBookSolve.addPerson(Person(name = "${i+1}" + " 번째 사람", number = "" + i + " 전화번호"))
        }

        return phoneBookSolve
    }

    fun createFakePhoneBookList(phoneBookSolve: PhoneBookSolve) {
        val layoutInflater = LayoutInflater.from(this@PhoneBookSolveActivity)
        val container = findViewById<LinearLayout>(R.id.phoneBookListContainer)
        for (i in 0 until phoneBookSolve.personList.size) {
            val view = layoutInflater.inflate(R.layout.phone_book_item_solve, null)
            val personNameView = view.findViewById<TextView>(R.id.person_name)
            personNameView.text = phoneBookSolve.personList[i].name
            container.addView(view)

            addSetOnClickListener(phoneBookSolve.personList[i], view)
        }
    }

    fun addSetOnClickListener(person: Person, view: View) {
        view.setOnClickListener {
            val intent = Intent(this@PhoneBookSolveActivity, PhoneBookDetailSolveActivity::class.java)
            intent.putExtra("name", person.name)
            intent.putExtra("number", person.number)
            startActivity(intent)
        }
    }
}

class PhoneBookSolve() {
    // 전화번호부
    val personList = ArrayList<Person>()

    fun addPerson(person: Person) {
        personList.add(person)
    }
}

class Person(val name: String, val number: String) {

}