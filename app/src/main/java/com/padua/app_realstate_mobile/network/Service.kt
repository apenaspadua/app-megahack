package com.padua.app_realstate_mobile.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service {
    private const val baseUrl = "https://realstatesolution.herokuapp.com"

       fun getRetrofitInstance(path : String) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
