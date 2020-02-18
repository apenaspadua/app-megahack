package com.padua.app_realstate_mobile.ui.searchImmobile

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ListAdapter
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.padua.app_realstate_mobile.R
import com.padua.app_realstate_mobile.network.bean.ImmobileResponse
import com.padua.app_realstate_mobile.ui.searchImmobile.adapter.SearchAdapter
import kotlinx.android.synthetic.main.activity_search_immobile.*

@RequiresApi(Build.VERSION_CODES.M)
class SearchImmobileActivity : AppCompatActivity() {

    private lateinit var interactor: SeachImmobileContract.Interactor
    private lateinit var adapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_immobile)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        interactor = SearchImmobileInteractor(this)
        getListimmobile()
    }

    private fun getListimmobile() {
        progressBarList.visibility = View.VISIBLE
        interactor.getListImmobile()
    }

    fun createList(list: List<ImmobileResponse>){
        progressBarList.visibility = View.GONE
        val recyclerView = recycler
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SearchAdapter(list, this)
        recyclerView.adapter = adapter
    }

    fun onError(message: String){
        Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        finish()
    }
}
