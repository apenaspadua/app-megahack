package com.padua.app_realstate_mobile.ui.start

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.padua.app_realstate_mobile.R
import com.padua.app_realstate_mobile.ui.details.DetailsImobileActivity
import com.padua.app_realstate_mobile.ui.login.LoginActivity
import com.padua.app_realstate_mobile.ui.register.RegisterActivity
import com.padua.app_realstate_mobile.utils.Utils
import kotlinx.android.synthetic.main.activity_start.*

@RequiresApi(Build.VERSION_CODES.M)
class StartActivity : AppCompatActivity() {

    companion object {
        var url = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        animateButtons()

       // linkAboutUs.setOnClickListener(buttonClickLogin)
        buttonLogin.setOnClickListener(buttonClickLogin)
        buttonReadCode.setOnClickListener(openSacan)
    }

    private val buttonClickLogin =
        View.OnClickListener {
            startActivity(Intent(this@StartActivity, LoginActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

    private val buttonClickRegister =
        View.OnClickListener {
            startActivity(Intent(this@StartActivity, RegisterActivity::class.java))
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

    private val openSacan =
        View.OnClickListener {
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
                    url = result.contents
                    changeActivity()
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

    private fun changeActivity(){
        startActivity(Intent(this@StartActivity, DetailsImobileActivity::class.java))
    }

    private fun animateButtons(){
        Utils.setPushDownAnimation(buttonReadCode)
        Utils.setPushDownAnimation(buttonLogin)
        Utils.setPushDownAnimation(linkAboutUs)
    }
}
