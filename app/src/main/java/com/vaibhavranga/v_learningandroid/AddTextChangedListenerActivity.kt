package com.vaibhavranga.v_learningandroid

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.vaibhavranga.v_learningandroid.databinding.ActivityAddTextChangedListenerBinding

class AddTextChangedListenerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddTextChangedListenerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddTextChangedListenerBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("TAG", "beforeTextChanged: ${s.toString()}")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("TAG", "onTextChanged: ${s.toString()}")
                binding.textView.text = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
                Log.d("TAG", "afterTextChanged: ${s.toString()}")
            }
        })
    }
}