package com.padua.app_realstate_mobile.ui.login

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.padua.app_realstate_mobile.R
import com.padua.app_realstate_mobile.utils.Utils
import kotlinx.android.synthetic.main.activity_login.*

@RequiresApi(Build.VERSION_CODES.M)
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        animateButtons()
    }

    private fun animateButtons(){
        Utils.setPushDownAnimation(buttonLogin)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        finish()
    }
}
