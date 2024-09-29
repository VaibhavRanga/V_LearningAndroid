package com.vaibhavranga.v_learningandroid

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vaibhavranga.v_learningandroid.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding
    private var isDoubleBackPressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)

        enableEdgeToEdge()

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.webView.loadUrl("https://www.google.com/")

        binding.webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                binding.progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.progressBar.visibility = View.GONE
            }
        }
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.setSupportZoom(true)

        val callback =
            this@WebViewActivity.onBackPressedDispatcher.addCallback(this@WebViewActivity) {
                if (binding.webView.canGoBack()) {
                    binding.webView.goBack()
                } else {
                    if (isDoubleBackPressed) {
                        handleOnBackPressed()
                    }
                    isDoubleBackPressed = true
                    Toast.makeText(this@WebViewActivity, "Press back again", Toast.LENGTH_SHORT)
                        .show()
                    Handler(Looper.getMainLooper()).postDelayed({
                        isDoubleBackPressed = false
                    }, 2000)
                }
            }
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        if (binding.webView.canGoBack()) {
//            binding.webView.goBack()
//        } else {
//            if (isDoubleBackPressed) {
//                onBackPressedDispatcher.onBackPressed()
//                return
//            }
//            isDoubleBackPressed = true
//            Toast.makeText(this, "Press back again", Toast.LENGTH_SHORT).show()
//            Handler(Looper.getMainLooper()).postDelayed({
//                isDoubleBackPressed = false
//            }, 2000)
//        }
//    }

//    override fun getOnBackInvokedDispatcher(): OnBackInvokedDispatcher {
//        if (binding.webView.canGoBack()) {
//            binding.webView.goBack()
//        } else {
//            if (isDoubleBackPressed) {
//                return super.getOnBackInvokedDispatcher()
//            }
//            isDoubleBackPressed = true
//            Toast.makeText(this, "Press back again", Toast.LENGTH_SHORT).show()
//            Handler(Looper.getMainLooper()).postDelayed({
//                isDoubleBackPressed = false
//            }, 2000)
//        }
//        return onBackInvokedDispatcher
//    }
}