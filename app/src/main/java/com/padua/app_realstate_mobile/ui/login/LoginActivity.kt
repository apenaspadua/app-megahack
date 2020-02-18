package com.padua.app_realstate_mobile.ui.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.padua.app_realstate_mobile.R
import com.padua.app_realstate_mobile.network.bean.LoginRequest
import com.padua.app_realstate_mobile.ui.home.HomeActivity
import com.padua.app_realstate_mobile.ui.register.RegisterActivity
import com.padua.app_realstate_mobile.utils.Utils
import kotlinx.android.synthetic.main.activity_login.*

@RequiresApi(Build.VERSION_CODES.M)
class LoginActivity : AppCompatActivity() {

    private lateinit var interactor: LoginContract.Interactor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        animateButtons()
        interactor = LoginInteractor(this)

        buttonLogin.setOnClickListener(buttonLoginClicked)
    }

    private val buttonLoginClicked =
        View.OnClickListener {
            if(validateForm()) {
                showLoading()
                Utils.hideSoftKeyBoard(this, constraint)
                val loginRequest = LoginRequest()
                loginRequest.email = editTextEmail.text.toString()
                loginRequest.password = editTextPass.text.toString()
                interactor.login(loginRequest)
            }
        }

    private fun validateForm(): Boolean {
        if (editTextEmail.text.toString().isEmpty()) {
            tilEmail.error = "Insira seu email!"
            return false
        } else if (editTextPass.text.toString().isEmpty()) {
            tilPass.error = "Insira sua senha!"
            return false
        }
        return true
    }

    fun navigateToHome(){
        startActivity(Intent(this, HomeActivity::class.java))
        finishAffinity()
    }

    fun onError(message: String){
        hideLoading()
        Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    private fun showLoading(){
        progress_bar.visibility = View.VISIBLE
        text_button_login.visibility = View.GONE
    }

    private fun hideLoading(){
        progress_bar.visibility = View.GONE
        text_button_login.visibility = View.VISIBLE
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
