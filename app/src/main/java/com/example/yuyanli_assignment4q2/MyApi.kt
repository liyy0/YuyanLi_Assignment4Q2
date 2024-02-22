package com.example.yuyanli_assignment4q2

import retrofit2.Call
import retrofit2.http.GET

interface MyApi {
    @GET("everything?q=bitcoin&apiKey=c0814ae1400c40789ceb8852fc1cc59d")
    fun getNews(): Call<News>
}
