package com.example.recycler

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("movielist.json")
    fun getCourse(): Call<List<MovieModel>>
}