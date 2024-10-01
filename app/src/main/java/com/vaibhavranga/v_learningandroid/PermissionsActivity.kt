package com.vaibhavranga.v_learningandroid

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.READ_MEDIA_IMAGES
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PermissionsActivity : AppCompatActivity() {
    private val locReqCode = 100
    private val multipleRequestsCode = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_permissions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Single permission request

        /*if (checkPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            Toast.makeText(this@MainActivity, "Access fine location permission already granted: application working now", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@MainActivity, "Access fine location permission not granted hence, requesting location permission", Toast.LENGTH_SHORT).show()
            requestPermission(ACCESS_FINE_LOCATION)
        }
    }

    private fun checkPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(this@MainActivity, permission) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission(permission: String) {
        ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), locReqCode)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == locReqCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "Location permission request granted: application working now", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "Location permission request denied: inform user about need of permission", Toast.LENGTH_SHORT).show()
            }
        }*/




        //Multiple requests in a go

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkPermission(ACCESS_FINE_LOCATION) && checkPermission(READ_MEDIA_IMAGES)) {
                Toast.makeText(this, "Both permissions already granted: app continuing", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Requesting permissions", Toast.LENGTH_SHORT).show()
                requestPermissions(arrayOf(ACCESS_FINE_LOCATION, READ_MEDIA_IMAGES))
            }
        } else {
            if (checkPermission(ACCESS_FINE_LOCATION) && checkPermission(READ_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "Both permissions already granted: app continuing", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Requesting permissions", Toast.LENGTH_SHORT).show()
                requestPermissions(arrayOf(ACCESS_FINE_LOCATION, READ_EXTERNAL_STORAGE))
            }
        }
    }

    private fun checkPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermissions(permissions: Array<String>) {
        ActivityCompat.requestPermissions(this, permissions, multipleRequestsCode)
    }

    private fun requestPermission(permission: Array<String>) {
        ActivityCompat.requestPermissions(this, permission, 101)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == multipleRequestsCode && grantResults.isNotEmpty()) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Location permission granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Requesting permission again after explaining the need", Toast.LENGTH_SHORT).show()
                requestPermission(arrayOf(ACCESS_FINE_LOCATION))
            }
            if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Read media images permission granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Requesting permission again after explaining the need", Toast.LENGTH_SHORT).show()
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    requestPermission(arrayOf(READ_MEDIA_IMAGES))
                } else {
                    requestPermission(arrayOf(READ_EXTERNAL_STORAGE))
                }
            }
        } else if (requestCode == 101 && grantResults.isNotEmpty()) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@PermissionsActivity, "Single permission granted in the second go", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@PermissionsActivity, "Single permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}