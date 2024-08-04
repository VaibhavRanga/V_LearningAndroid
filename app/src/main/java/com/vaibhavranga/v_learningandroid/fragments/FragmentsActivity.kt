package com.vaibhavranga.v_learningandroid.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.vaibhavranga.v_learningandroid.R
import com.vaibhavranga.v_learningandroid.databinding.ActivityFragmentsBinding

class FragmentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentsBinding
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        fragmentManager = supportFragmentManager
        loadFragment(AFragment(), true)

        binding.buttonFragA.setOnClickListener {
            loadFragment(AFragment(), false)
        }

        binding.buttonFragB.setOnClickListener {
            loadFragment(BFragment(), false)
        }

        binding.buttonFragC.setOnClickListener {
            loadFragment(CFragment(), false)
        }
    }

    private fun loadFragment(frag: Fragment, isRoot: Boolean) {
        val ft = fragmentManager.beginTransaction()

        if (isRoot)
            ft.add(R.id.frameLayout, frag)
        else
            ft.replace(R.id.frameLayout, frag)

        //ft.remove()

        ft.commit()
    }
}