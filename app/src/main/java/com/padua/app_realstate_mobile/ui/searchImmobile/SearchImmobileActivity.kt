package com.padua.app_realstate_mobile.ui.searchImmobile

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.padua.app_realstate_mobile.R
import com.padua.app_realstate_mobile.network.bean.ImmobileResponse

@RequiresApi(Build.VERSION_CODES.M)
class SearchImmobileActivity : AppCompatActivity() {

    private lateinit var interactor: SeachImmobileContract.Interactor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_immobile)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        interactor = SearchImmobileInteractor(this)
        getListimmobile()
    }

    private fun getListimmobile() {
        interactor.getListImmobile()
    }

    fun createList(list: List<ImmobileResponse>){
        list
//        list = onCreateListFamilyGroup(dependentsResponse)
//        activity.recyclerViewFamilyGroup.layoutManager = LinearLayoutManager(activity.applicationContext)
//        val familyGroupListAdapter = FamilyGroupAdapter(activity, list, view)
//        activity.recyclerViewFamilyGroup.adapter = familyGroupListAdapter
//        view?.hideLoading()
//
//        if(list.isEmpty()){
//            activity.constraintEmptyDependents.visibility = View.VISIBLE
//        }
    }

    fun onError(message: String){
        Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }
}
