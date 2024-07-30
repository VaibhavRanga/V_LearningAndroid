package com.vaibhavranga.v_learningandroid.recyclerview

import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.window.OnBackInvokedDispatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vaibhavranga.v_learningandroid.R
import com.vaibhavranga.v_learningandroid.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding
    private val contactsArray = ArrayList<ContactModel>()
    private var isDoubleBackPressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)

        setContentView(binding.root)

        for (i in 0..10) {
            contactsArray.add(ContactModel(R.drawable.tom_cruise, "Tom Cruise", "9343346599"))
            contactsArray.add(
                ContactModel(
                    R.drawable.scarlet_johansson,
                    "Scarlet Johansson",
                    "7382944381"
                )
            )
            contactsArray.add(ContactModel(R.drawable.kate_winslet, "Kate Winslet", "7782237423"))
        }

        val contactsRecyclerViewAdapter =
            ContactsRecyclerViewAdapter(this@RecyclerViewActivity, contactsArray)
        binding.recyclerViewContacts.layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
        binding.recyclerViewContacts.adapter = contactsRecyclerViewAdapter

        binding.floatingActionButton.setOnClickListener {
            val addContactDialogBox = Dialog(this@RecyclerViewActivity)

            addContactDialogBox.setContentView(R.layout.custom_dialog_box)
            addContactDialogBox.setCancelable(false)

            val editTextName = addContactDialogBox.findViewById<EditText>(R.id.editTextName)
            val editTextNumber = addContactDialogBox.findViewById<EditText>(R.id.editTextNumber)
            val buttonSave = addContactDialogBox.findViewById<Button>(R.id.buttonSave)
            val buttonCancel = addContactDialogBox.findViewById<Button>(R.id.buttonCancel)

            buttonSave.setOnClickListener {
                val name = editTextName.text.toString()
                val number = editTextNumber.text.toString()

                if (name.trim() != "" && number.trim() != "") {
                    val contact = ContactModel(R.drawable.tom_cruise, name, number)
                    contactsArray.add(contact)

                    contactsRecyclerViewAdapter.notifyItemInserted(contactsArray.size - 1)
                    binding.recyclerViewContacts.scrollToPosition(contactsArray.size - 1)

                    addContactDialogBox.dismiss()
                } else {
                    Toast.makeText(
                        this@RecyclerViewActivity,
                        "Enter details first",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            buttonCancel.setOnClickListener {
                addContactDialogBox.dismiss()
            }

            addContactDialogBox.show()
        }
    }
}