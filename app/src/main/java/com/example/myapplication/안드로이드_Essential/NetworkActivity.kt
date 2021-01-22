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
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNetworkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNetworkBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        val urlString: String = "http://mellowcore.org/json/students/"

        NetworkAsyncTask(
            "http://mellowcode.org/json/students/",
            binding,
            this@NetworkActivity
        ).execute()
    }
}

class NetworkAsyncTask(
    private val urlString: String,
    val binding: ActivityNetworkBinding,
    val networkActivity: NetworkActivity
) : AsyncTask<Any?, Any?, Any?>() {
    private lateinit var data: Array<PersonFromServer>
    val context: Context = Context()
    override fun doInBackground(vararg params: Any?): Any? {
        Log.d("urlString:; ", urlString)
        val url: URL = URL(urlString)
        val connection: HttpURLConnection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type", "application/json")

        var buffer = ""

        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            Log.d("conn", "inputStream:: ${connection.inputStream}")
            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
            Log.d("conn_context", "inputStream:: $buffer")
        }

        data = Gson().fromJson(buffer, Array<PersonFromServer>::class.java)
        Log.d("conn_context", "inputStream:: $data")
        val age = data[0].age
        Log.d("conn_age", "age:: $age")

        return data
//        return null
    }

    override fun onPostExecute(result: Any?) {
//        super.onPostExecute(result)

        val recyclerViewAdapter = NetworkAdapter(data, networkActivity)
        binding.recyclerView.adapter = recyclerViewAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        // RecyclerView 구분선 넣기
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                networkActivity,
                LinearLayoutManager.VERTICAL
            )
        )
    }

}


class NetworkAdapter(
    val itemList: Array<PersonFromServer>,
//    val layoutInflater: LayoutInflater
    val context: NetworkActivity
) : RecyclerView.Adapter<NetworkAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val personName: TextView
        val personAge: TextView
        val personIntro: TextView

        init {
            personName = itemView.findViewById(R.id.network_name)
            personAge = itemView.findViewById(R.id.network_age)
            personIntro = itemView.findViewById(R.id.network_intro)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = inflater.inflate(R.layout.activity_network_detail, parent, false)
        val view =
            LayoutInflater.from(context).inflate(R.layout.activity_network_detail, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.text = itemList[position].name
        holder.personAge.text = itemList[position].age.toString()
        holder.personIntro.text = itemList[position].intro
    }
}