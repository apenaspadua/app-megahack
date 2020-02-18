package com.padua.app_realstate_mobile.ui.searchImmobile

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.padua.app_realstate_mobile.network.bean.ImmobileResponse
import com.padua.app_realstate_mobile.network.service.AppAPI
import com.padua.app_realstate_mobile.network.service.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class SearchImmobileInteractor(val output: SearchImmobileActivity):
    SeachImmobileContract.Interactor {

    private var api = Service.getRetrofitInstance().create(AppAPI::class.java)

    override fun getListImmobile() {
        val call: Call<List<ImmobileResponse>> = api.getImmobile()
        call.enqueue(object : Callback<List<ImmobileResponse>> {

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onResponse( call: Call<List<ImmobileResponse>>,
                                     response: Response<List<ImmobileResponse>>) {
                val immobileResponse = response.body()

                if(immobileResponse != null){
                   // getDependentsRespons = dependentsResponse
                    output.createList(immobileResponse)
                } else {
                    output.onError(response.message())
                }
            }

            override fun onFailure(call: Call<List<ImmobileResponse>>, t: Throwable) {
                Log.d("TAG", t.localizedMessage)
            }
        })

    }
}