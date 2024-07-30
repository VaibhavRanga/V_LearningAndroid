package com.vaibhavranga.v_learningandroid.recyclerview

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.vaibhavranga.v_learningandroid.R

class ContactsRecyclerViewAdapter(
    private val context: Context,
    private val contactsArray: ArrayList<ContactModel>
) : RecyclerView.Adapter<ContactsRecyclerViewAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactImage = itemView.findViewById<ImageView>(R.id.circleImageViewContactImage)
        val contactName = itemView.findViewById<TextView>(R.id.textViewContactName)
        val contactNumber = itemView.findViewById<TextView>(R.id.textViewContactNumber)
        val relativeLayoutMain = itemView.findViewById<RelativeLayout>(R.id.relativeLayoutMain)
        val imageViewDeleteContact = itemView.findViewById<ImageView>(R.id.imageViewDeleteContact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.contacts_recycler_view_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactsArray.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val contact = contactsArray[position]

        holder.contactName.text = contact.contactName
        holder.contactImage.setImageResource(contact.contactImage)
        holder.contactNumber.text = contact.contactNumber

        holder.relativeLayoutMain.setOnClickListener {
            val updateContactDialog = Dialog(context).apply {
                this.setContentView(R.layout.custom_dialog_box)
                this.setCancelable(false)
                this.show()

                val textViewHeading = this.findViewById<TextView>(R.id.textViewHeading)
                val editTextName = this.findViewById<EditText>(R.id.editTextName)
                val editTextNumber = this.findViewById<EditText>(R.id.editTextNumber)
                val buttonSave = this.findViewById<Button>(R.id.buttonSave)
                val buttonCancel = this.findViewById<Button>(R.id.buttonCancel)

                textViewHeading.text = "Update contact"
                editTextName.setText(contact.contactName)
                editTextNumber.setText(contact.contactNumber)

                buttonSave.setOnClickListener {
                    val name = editTextName.text.toString()
                    val number = editTextNumber.text.toString()

                    if (name.trim() != "" && number.trim() != "") {
                        val updatedContact = ContactModel(contact.contactImage, name, number)

                        contactsArray[position] = updatedContact
                        notifyItemChanged(position)

                        dismiss()
                    } else {
                        Toast.makeText(context, "Enter details first", Toast.LENGTH_SHORT).show()
                    }
                }

                buttonCancel.setOnClickListener {
                    dismiss()
                }
            }
        }

        holder.imageViewDeleteContact.setOnClickListener {
            val deleteDialog = MaterialAlertDialogBuilder(context)

            deleteDialog.setTitle("Delete ${contact.contactName}")
            deleteDialog.setMessage("Are you sure you want to delete this contact?")

            deleteDialog.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    contactsArray.remove(contact)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, contactsArray.size)
                }
            })

            deleteDialog.setNegativeButton("No", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }
            })

            deleteDialog.show()
        }
    }


    /*class MyViewHolder(private val context: Context, private val binding: ContactsRecyclerViewListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: ContactModel, position: Int, clickListener: (position: Int) -> Unit) {
            binding.textViewContactName.text = contact.contactName
            binding.textViewContactNumber.text = contact.contactNumber
            binding.circleImageViewContactImage.setImageResource(contact.contactImage)
            binding.linearLayout.setOnClickListener {
                clickListener(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ContactsRecyclerViewListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(parent.context, binding)
    }

    override fun getItemCount(): Int {
        return contactsArray.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val contact = contactsArray[position]

        holder.bind(contact, position, clickListener)
    }*/
}
