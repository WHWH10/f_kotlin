package com.example.myapplication.안드로이드_Essential

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityNetworkBinding
import com.example.myapplication.databinding.ActivityNetworkSolveBinding
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_network_detail.view.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkSolveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNetworkSolveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetworkSolveBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        NetworkSolveAsyncTask("http://mellowcode.org/json/students/").execute()
        NetworkSolveAsyncTask(
            "http://mellowcode.org/json/students/",
            LayoutInflater.from(this@NetworkSolveActivity),
            binding.recyclerView
        ).execute()
    }
}

class NetworkSolveAsyncTask(
    private val urlString: String,
    val inflater: LayoutInflater,
    val recyclerView: RecyclerView
) : AsyncTask<Any?, Any?, Array<PersonFromServer>>() {

    // doInBackground 마친 후 실행하는 함수
    override fun onPostExecute(result: Array<PersonFromServer>?) {
        val personAdapter = NetworkSolveAdapter(result!!, inflater)
        recyclerView.adapter = personAdapter
        super.onPostExecute(result)
    }


    override fun doInBackground(vararg params: Any?): Array<PersonFromServer> {
        val url: URL = URL(urlString)
        val connection: HttpURLConnection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type", "application/json")

        var buffer = ""

        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
        }

        val data = Gson().fromJson(buffer, Array<PersonFromServer>::class.java)
        val age = data[0].age

        return data
//        return null
    }
}

class NetworkSolveAdapter(val personList: Array<PersonFromServer>, val inflater: LayoutInflater) :
    RecyclerView.Adapter<NetworkSolveAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val age: TextView
        val intro: TextView

        init {
            name = itemView.findViewById(R.id.network_name)
            age = itemView.findViewById(R.id.network_age)
            intro = itemView.findViewById(R.id.network_intro)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.activity_network_detail, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = personList[position].name ?: ""
        holder.age.text = personList[position].age.toString()
        holder.intro.text = personList[position].intro ?: ""
    }
}