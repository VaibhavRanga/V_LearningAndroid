package com.vaibhavranga.v_learningandroid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vaibhavranga.v_learningandroid.databinding.ActivityTopAppBarBinding

class TopAppBarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTopAppBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopAppBarBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.materialToolbar.overflowIcon = ResourcesCompat.getDrawable(resources, R.drawable.baseline_more_vert_24, null)

        binding.materialToolbar.setNavigationOnClickListener {
            Toast.makeText(this@TopAppBarActivity, "Navigation icon clicked", Toast.LENGTH_SHORT).show()
        }

        binding.materialToolbar.setOnMenuItemClickListener { item ->
            if (item.itemId == R.id.toolbar_edit) {
                Toast.makeText(this@TopAppBarActivity, "Edit button clicked", Toast.LENGTH_SHORT).show()
            } else if (item.itemId == R.id.toolbar_logout) {
                Toast.makeText(this@TopAppBarActivity, "Log out button clicked", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}