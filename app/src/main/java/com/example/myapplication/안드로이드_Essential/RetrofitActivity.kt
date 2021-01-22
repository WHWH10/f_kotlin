package com.example.myapplication.안드로이드_Essential

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
import com.example.myapplication.databinding.ActivityNetworkLibraryBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNetworkLibraryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetworkLibraryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        // GET 요청
        service.getStudentsList().enqueue(object : Callback<ArrayList<PersonFromServer>> {
            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("RetrofitLog", "isFail:: ERROR")
                call.isCanceled
                call.isExecuted
                call.cancel()
            }

            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if (response.isSuccessful) {
                    val personList = response.body()
                    Log.d("RetrofitLog", "isSuccess:: ${personList?.get(0)?.name}")
                    val statusCode = response.code()
                    Log.d("RetrofitLog", "isSuccess:: Code :: $statusCode")
                    val error = response.errorBody()
                    Log.d("RetrofitLog", "isSuccess:: error :: $error")
                    val header = response.headers()
                    Log.d("RetrofitLog", "isSuccess:: header :: $header")

                    val adapter =
                        RetrofitAdapter(personList, LayoutInflater.from(this@RetrofitActivity))
                    binding.recyclerView.adapter = adapter
                    val layoutManager = LinearLayoutManager(this@RetrofitActivity)
                    layoutManager.reverseLayout = true
                    layoutManager.stackFromEnd = true
//                    binding.recyclerView.layoutManager = LinearLayoutManager(this@RetrofitActivity)
                    binding.recyclerView.layoutManager = layoutManager
                    binding.recyclerView.addItemDecoration(
                        DividerItemDecoration(
                            this@RetrofitActivity,
                            LinearLayoutManager.VERTICAL
                        )
                    )
                } else {

                }
            }

        })

        // POST 요청
        val params = HashMap<String, Any>()
        params["name"] = "김아무개테스트"
        params["age"] = 100
        params["intro"] = "HELLO TEST"
        service.createStudent(params).enqueue(object: Callback<PersonFromServer> {
            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
                Log.d("Retrofit_POST", "error")
            }

            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if(response.isSuccessful) {
                    val result = response.body()
                    Log.d("Retrofit_POST", "success:: $result")
                }
            }

        })

        // POST 요청2
        val person = PersonFromServer(name = "곱창김", age = 13, intro = "저는 곱창김입니다")
        service.createStudentEasy(person).enqueue(object: Callback<PersonFromServer> {
            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if(response.isSuccessful) {
                    val result = response.body()
                    Log.d("Retrofit_POST2", "success: ${result?.name}")
                }
            }

        })
    }
}

class RetrofitAdapter(
    val personList: ArrayList<PersonFromServer>?,
    val layoutInflater: LayoutInflater
) : RecyclerView.Adapter<RetrofitAdapter.ViewHolder>() {
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
        val view = layoutInflater.inflate(R.layout.activity_network_detail, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (personList != null) {
            return personList.size
        } else {
            return 0
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = personList?.get(position)?.name ?: ""
        holder.age.text = personList?.get(position)?.age.toString()
        holder.intro.text = personList?.get(position)?.intro ?: ""
    }
}