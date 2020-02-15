package com.padua.app_realstate_mobile.view.home

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.zxing.integration.android.IntentIntegrator
import com.padua.app_realstate_mobile.R
import com.padua.app_realstate_mobile.utils.Utils
import kotlinx.android.synthetic.main.activity_home.*

@RequiresApi(Build.VERSION_CODES.M)
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;

        animateButtons()
        buttonReadCode.setOnClickListener {
          openSacan()
        }
    }

    fun openSacan(){
        val scanner = IntentIntegrator(this)
        scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
        scanner.setBeepEnabled(false)
        scanner.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

    private fun animateButtons(){
        Utils.setPushDownAnimation(buttonReadCode)
        Utils.setPushDownAnimation(linkOurPromisse)
        Utils.setPushDownAnimation(buttonRegister)
    }
}
