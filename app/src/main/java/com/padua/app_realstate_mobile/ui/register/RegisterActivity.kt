package com.padua.app_realstate_mobile.ui.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padua.app_realstate_mobile.R
import com.padua.app_realstate_mobile.utils.Utils
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        animateButtons()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        finish()
    }

    private fun animateButtons(){
        Utils.setPushDownAnimation(buttonRegister)
    }
}
