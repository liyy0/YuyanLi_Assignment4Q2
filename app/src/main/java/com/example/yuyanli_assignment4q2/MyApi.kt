package com.example.yuyanli_assignment4q2

import retrofit2.Call
import retrofit2.http.GET

interface MyApi {
    @GET("everything?q=bitcoin&apiKey=c0814ae1400c40789ceb8852fc1cc59d")
    fun getNews(): Call<News>

    @GET("everything?q=apple&from=2024-02-25&to=2024-02-25&sortBy=popularity&apiKey=c0814ae1400c40789ceb8852fc1cc59d")
    fun getApple(): Call<News>
}
