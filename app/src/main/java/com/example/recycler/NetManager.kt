package com.example.recycler

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetManager {
    var retrofit: Retrofit? = null
    var api: Api? = null

    fun apiClient(): Api{
        if(api == null){
            retrofit = Retrofit.Builder().baseUrl("https://www.howtodoandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            api = retrofit!!.create(Api::class.java)
        }
        return api!!
    }
}