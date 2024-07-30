package com.vaibhavranga.v_learningandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieDrawable
import com.vaibhavranga.v_learningandroid.databinding.ActivityLottieAnimationBinding

class LottieAnimationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLottieAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLottieAnimationBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonLottie1.setOnClickListener {
            binding.lottieAnimationView.apply {

                setAnimation(R.raw.lottie_square)
                repeatCount = LottieDrawable.INFINITE
                playAnimation()
            }
        }

        binding.buttonLottie2.setOnClickListener {
            binding.lottieAnimationView.apply {

                setAnimation(R.raw.lottie_mushroom)
                repeatCount = LottieDrawable.INFINITE
                playAnimation()
            }
        }

        binding.buttonStop.setOnClickListener {
            binding.lottieAnimationView.apply {

                cancelAnimation()
            }
        }
    }
}