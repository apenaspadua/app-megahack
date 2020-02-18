package com.padua.app_realstate_mobile.network.service

import com.padua.app_realstate_mobile.network.bean.ImmobileResponse
import com.padua.app_realstate_mobile.network.bean.LoginRequest
import com.padua.app_realstate_mobile.network.bean.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AppAPI {

    @POST("/login")
    fun loginUser(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @GET("/immobile")
    fun getImmobile() : Call<List<ImmobileResponse>>
}