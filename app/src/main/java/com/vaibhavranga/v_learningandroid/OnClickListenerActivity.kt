package com.vaibhavranga.v_learningandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vaibhavranga.v_learningandroid.databinding.ActivityOnClickListenerBinding

class OnClickListenerActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityOnClickListenerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnClickListenerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOnClick.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                binding.textView.text = "Button clicked"
            }
        })

        binding.buttonLongPress.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {

                Toast.makeText(
                    this@OnClickListenerActivity,
                    "Long press detected",
                    Toast.LENGTH_SHORT
                ).show()
                return true
            }
        })
    }

    override fun onClick(v: View?) {
        val btn = v as Button

        binding.textView.text = "Button clicked"
    }
}