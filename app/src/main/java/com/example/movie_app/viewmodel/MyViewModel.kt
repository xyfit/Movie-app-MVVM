package com.example.movie_app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie_app.models.MovieModel
import com.example.movie_app.repository.AppRepository

class MyViewModel: ViewModel() {
    private val repository = AppRepository()

    val dataList = MutableLiveData<List<MovieModel>>()
    val error = MutableLiveData<String>()
    val progress = MutableLiveData<Boolean>()

    fun movieLoadApi(){
        repository.loadApi(dataList, error, progress)
    }
}