package com.vaibhavranga.v_learningandroid

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioGroup
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







        val spinnerItems = listOf("One", "Two", "Three")

        binding.spinner.adapter = ArrayAdapter<String>(this@OnClickListenerActivity, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        binding.spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@OnClickListenerActivity, spinnerItems[p2], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }







        //To use default checked button Id
        //val selectedId = binding.radioGroup.checkedRadioButtonId

        var selectedRadioButton = binding.radioGroup.checkedRadioButtonId
        binding.radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                when (p1) {
                    R.id.radioButtonA -> {
                        //do some work
                    }
                    R.id.radioButtonB -> {
                        //do some work
                    }
                }
            }
        })
    }

    override fun onClick(v: View?) {
        val btn = v as Button

        binding.textView.text = "Button clicked"
    }
}