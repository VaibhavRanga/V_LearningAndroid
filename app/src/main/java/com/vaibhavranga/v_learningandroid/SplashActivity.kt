package com.vaibhavranga.v_learningandroid

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.vaibhavranga.v_learningandroid.databinding.ActivitySplashBinding
import com.vaibhavranga.v_learningandroid.fragments.FragmentsActivity
import com.vaibhavranga.v_learningandroid.tablayoutviewpager2.TabViewPager2Activity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed(object : Runnable {
            override fun run() {
                val iNext = Intent(this@SplashActivity, WebViewActivity::class.java)
                iNext.putExtra("Name", "Sam")
                iNext.putExtra("Age", 10)

                startActivity(iNext)
                finish()
            }
        }, 3000)
    }
}