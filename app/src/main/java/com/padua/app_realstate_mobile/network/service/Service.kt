package com.padua.app_realstate_mobile.network.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service {
    private const val baseUrl = "https://realstatesolution.herokuapp.com"

       fun getRetrofitInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
