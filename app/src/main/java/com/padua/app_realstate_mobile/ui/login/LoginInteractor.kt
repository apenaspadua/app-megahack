package com.padua.app_realstate_mobile.ui.login

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.padua.app_realstate_mobile.network.bean.LoginRequest
import com.padua.app_realstate_mobile.network.bean.LoginResponse
import com.padua.app_realstate_mobile.network.service.AppAPI
import com.padua.app_realstate_mobile.network.service.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class LoginInteractor(val output: LoginActivity): LoginContract.Interactor {

    private val api = Service.getRetrofitInstance().create(AppAPI::class.java)

    override fun login(loginRequest: LoginRequest) {
        val call: Call<LoginResponse> = api.loginUser(loginRequest)
        call.enqueue(object : Callback<LoginResponse> {

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("Login", t.localizedMessage)
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val loginResponse = response.body()

                if(loginResponse is LoginResponse ){
                    if(response.isSuccessful){
                        output.navigateToHome()
                    } else {
                        output.onError(response.message())
                    }
                }  else {
                    output.onError("Usuário ou senha inválidos")
                }
            }
        })
    }
}

