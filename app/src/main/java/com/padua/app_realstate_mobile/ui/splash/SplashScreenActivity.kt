package com.padua.app_realstate_mobile.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.padua.app_realstate_mobile.R
import com.padua.app_realstate_mobile.ui.start.StartActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent(this, StartActivity::class.java))
            finish()
        }, 4000)
    }
}