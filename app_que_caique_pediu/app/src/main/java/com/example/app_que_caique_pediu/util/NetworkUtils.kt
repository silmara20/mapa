package com.example.app_que_caique_pediu.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//base do retrofit basicamente o motor pra ele funcionar
class NetworkUtils {
    companion object {
        fun getRetrofitInstance(path: String) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        }
    }
}
