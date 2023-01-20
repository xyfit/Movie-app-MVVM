package com.example.recycler.nerwork

import com.example.recycler.models.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("movielist.json")
    fun getCourse(): Call<List<MovieModel>>
}