package com.example.movie_app.nerwork

import com.example.movie_app.models.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("movielist.json")
    fun getCourse(): Call<List<MovieModel>>
}