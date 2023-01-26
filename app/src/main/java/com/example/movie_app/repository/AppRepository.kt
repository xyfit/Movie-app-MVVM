package com.example.movie_app.repository

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.movie_app.OnItemCallback
import com.example.movie_app.UserAdapter
import com.example.movie_app.models.MovieModel
import com.example.movie_app.nerwork.NetManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppRepository {
    fun loadApi(successList: MutableLiveData<List<MovieModel>>, error: MutableLiveData<String>, progress: MutableLiveData<Boolean>){
        NetManager.apiClient().getCourse().enqueue(object : Callback<List<MovieModel>> {
            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                if (response.isSuccessful) {
                    val getData = response.body()
                    getData?.let {
                        successList.value = getData
                        progress.value = false
                    }
                    val fffff = getData?.map { it.name }?.joinToString("\n")
                    Log.d("sssssssddfgfg", "$fffff")
                }
            }

            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                error.value = t.localizedMessage
                progress.value = false
            }
        })
    }
}