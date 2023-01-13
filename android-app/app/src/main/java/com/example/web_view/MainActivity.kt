package com.example.web_view

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.web_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webView = binding.webView
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

                // NOT TESTED
                // webView.evaluateJavascript("window.localStorage.setItem('appToken','dc7EqC8h8fla5RiSDhTaPwKpkaNNZvu4');", null);

                // OKAY
                webView.loadUrl("javascript:localStorage.setItem('appToken','dc7EqC8h8fla5RiSDhTaPwKpkaNNZvu4');");
            }
        }

        webView.loadUrl("http://10.0.2.2:3000")
    }

}