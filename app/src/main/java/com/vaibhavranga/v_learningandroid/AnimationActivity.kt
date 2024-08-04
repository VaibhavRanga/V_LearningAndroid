package com.vaibhavranga.v_learningandroid

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.vaibhavranga.v_learningandroid.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val translateAnimation = AnimationUtils.loadAnimation(this@AnimationActivity, R.anim.translate_animation)
        val alphaAnimation = AnimationUtils.loadAnimation(this@AnimationActivity, R.anim.alpha_animation)
        val rotateAnimation = AnimationUtils.loadAnimation(this@AnimationActivity, R.anim.rotate_animation)
        val scaleAnimation = AnimationUtils.loadAnimation(this@AnimationActivity, R.anim.scale_animation)

        val movingBall = AnimationUtils.loadAnimation(this@AnimationActivity, R.anim.moving_ball)

        val football = AnimationUtils.loadAnimation(this@AnimationActivity, R.anim.football)

        //jumping ball animation
        val jumpingBall1 = AnimationUtils.loadAnimation(this@AnimationActivity, R.anim.bouncing_ball_1)
        val jumpingBall2 = AnimationUtils.loadAnimation(this@AnimationActivity, R.anim.bouncing_ball_2)
        val jumpingBall3 = AnimationUtils.loadAnimation(this@AnimationActivity, R.anim.bouncing_ball_3)
        val jumpingBall4 = AnimationUtils.loadAnimation(this@AnimationActivity, R.anim.bouncing_ball_4)

        //moving car with rotating wheels animation
        val movingCar = AnimationUtils.loadAnimation(this@AnimationActivity, R.anim.car_movement)
        val carWheelFront = AnimationUtils.loadAnimation(this@AnimationActivity, R.anim.car_wheel_rotation)
        val carWheelBack = AnimationUtils.loadAnimation(this@AnimationActivity, R.anim.car_wheel_rotation)

        binding.imageViewCar.animation = movingCar
        binding.imageViewCarWheelFront.animation = carWheelFront
        binding.imageViewCarWheelBack.animation = carWheelBack

        /*binding.imageViewBall.animation = jumpingBall1

        jumpingBall1.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.imageViewBall.animation = jumpingBall2
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })

        jumpingBall2.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.imageViewBall.animation = jumpingBall3
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })

        jumpingBall3.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.imageViewBall.animation = jumpingBall4
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })*/

//        translateAnimation.setAnimationListener(object : Animation.AnimationListener {
//            override fun onAnimationStart(animation: Animation?) {
//
//            }
//
//            override fun onAnimationEnd(animation: Animation?) {
//                binding.textView.animation = rotateAnimation
//            }
//
//            override fun onAnimationRepeat(animation: Animation?) {
//
//            }
//        })
    }
}