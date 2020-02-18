package com.padua.app_realstate_mobile.ui.home

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.padua.app_realstate_mobile.R
import com.padua.app_realstate_mobile.ui.myImmobile.MyImmobileActivity
import com.padua.app_realstate_mobile.ui.register.RegisterImmobileActivity
import com.padua.app_realstate_mobile.ui.searchImmobile.SearchImmobileActivity
import com.padua.app_realstate_mobile.utils.Utils
import kotlinx.android.synthetic.main.activity_home.*

@RequiresApi(Build.VERSION_CODES.M)
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        animateButtons()
        buttonTenhoImovel.setOnClickListener(buttonClickTenhoImovel)
        buttonBuscarImovel.setOnClickListener(buttonClickQueroImovel)
    }

    private val buttonClickTenhoImovel =
        View.OnClickListener {
            startActivity(Intent(this, RegisterImmobileActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

    private val buttonClickQueroImovel =
        View.OnClickListener {
            startActivity(Intent(this, SearchImmobileActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

    private fun animateButtons(){
        Utils.setPushDownAnimation(buttonTenhoImovel)
        Utils.setPushDownAnimation(buttonBuscarImovel)
    }
}
