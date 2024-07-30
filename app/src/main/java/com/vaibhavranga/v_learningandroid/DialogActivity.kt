package com.vaibhavranga.v_learningandroid

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vaibhavranga.v_learningandroid.databinding.ActivityDialogBinding
import com.vaibhavranga.v_learningandroid.databinding.CustomDialogBoxBinding

class DialogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            val addContactDialog = Dialog(this@DialogActivity)

//            val bind = CustomDialogBoxBinding.inflate(layoutInflater)
//            addContactDialog.setContentView(bind.root)

            addContactDialog.setContentView(R.layout.custom_dialog_box)

            val editTextName = addContactDialog.findViewById<EditText>(R.id.editTextName)
            val editTextNumber = addContactDialog.findViewById<EditText>(R.id.editTextNumber)
            val buttonSave = addContactDialog.findViewById<Button>(R.id.buttonSave)
            val buttonCancel = addContactDialog.findViewById<Button>(R.id.buttonCancel)

            addContactDialog.setCancelable(false)
            addContactDialog.show()

            buttonSave.setOnClickListener {
                val name = editTextName.text.toString()
                val number = editTextNumber.text.toString()

                if (name.trim() != "" && number.trim() != "") {
                    binding.textViewContactName.text = name
                    binding.textViewContactNumber.text = number

                    addContactDialog.dismiss()
                } else {
                    Toast.makeText(this@DialogActivity, "Enter details first", Toast.LENGTH_SHORT).show()
                }
            }

            buttonCancel.setOnClickListener {
                addContactDialog.dismiss()
            }
        }
    }
}