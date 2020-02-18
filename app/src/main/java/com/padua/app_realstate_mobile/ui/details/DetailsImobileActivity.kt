package com.padua.app_realstate_mobile.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.padua.app_realstate_mobile.R
import com.padua.app_realstate_mobile.ui.start.StartActivity.Companion.url

@SuppressLint("SetJavaScriptEnabled")
class DetailsImobileActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_imobile_avtivity)

        openWebview()
    }

    private fun openWebview(){
        webView = findViewById(R.id.webview)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url.toString())
                return true
            }
        }
        enableJavascript()
        webView.loadUrl(url)
    }

    private fun enableJavascript(){
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
    }
}
