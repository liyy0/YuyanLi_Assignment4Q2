package com.example.yuyanli_assignment4q2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    var base_url = "https://newsapi.org/v2/"
    var TAG = "MainActivity1111"
//    var TAGX = "Test 1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button_bitcoin = findViewById<TextView>(R.id.button_bitcoin)
        var button_apple = findViewById<TextView>(R.id.button_apples)
        button_bitcoin.setOnClickListener {
            getComments()
        }
        button_apple.setOnClickListener {
            getApple_news()
        }


        getComments()

    }

    fun setupRecyclerView(articlesList: List<Article>) {

        val recyclerView: RecyclerView = findViewById(R.id.news_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListAdapter(articlesList) {
//            Toast.makeText(this, "Clicked on ${it.title}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, detail_page::class.java)
            intent.putExtra("title", it.title)
            intent.putExtra("content", it.content)
            intent.putExtra("url", it.url)
            startActivity(intent)
        }
    }


    private fun getComments(){
//        val textview = findViewById<TextView>(R.id.textView2)
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val api = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(MyApi::class.java)
        api.getNews().enqueue(object :Callback<News>{
            override fun onResponse(
                call: Call<News>,
                response: Response<News>
            ) {
                Log.d(TAG, "onResponse: ${response}")
                if (response.isSuccessful){
                    val news = response.body()!!
//                    textview.text = news.articles[0].title
//                    callback(news)
                    setupRecyclerView(news.articles)
                    Log.d(TAG, "onResponse: ${news.articles[0].title}")
                }
            }
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun getApple_news(){
//        val textview = findViewById<TextView>(R.id.textView2)
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val api = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(MyApi::class.java)
        api.getApple().enqueue(object :Callback<News>{
            override fun onResponse(
                call: Call<News>,
                response: Response<News>
            ) {
                Log.d(TAG, "onResponse: ${response}")
                if (response.isSuccessful){
                    val news = response.body()!!
//                    textview.text = news.articles[0].title
//                    callback(news)
                    setupRecyclerView(news.articles)
                    Log.d(TAG, "onResponse: ${news.articles[0].title}")
                }
            }
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }


}
