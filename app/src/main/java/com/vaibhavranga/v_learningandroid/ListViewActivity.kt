package com.vaibhavranga.v_learningandroid

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.vaibhavranga.v_learningandroid.databinding.ActivityListViewBinding

class ListViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListViewBinding
    private lateinit var listItemAdapter: ArrayAdapter<String>
    private val arrayNames = ArrayList<String>()

    private lateinit var spinnerAdapter: ArrayAdapter<String>
    private val spinnerIDProofs = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)

        setContentView(binding.root)


//spinner


        spinnerIDProofs.apply {
            add("Aadhaar card")
            add("Voter ID card")
            add("PAN card")
            add("Driving license")
        }

        spinnerAdapter = ArrayAdapter<String>(
            this@ListViewActivity,
            android.R.layout.simple_spinner_dropdown_item,
            spinnerIDProofs
        )

        binding.spinner.adapter = spinnerAdapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()

                Toast.makeText(this@ListViewActivity, selectedItem, Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


//auto complete text view
        binding.autoCompleteTextView.threshold = 1
        val autoCompleteTextViewAdapter = ArrayAdapter<String>(this@ListViewActivity, android.R.layout.simple_spinner_dropdown_item, arrayNames)
        binding.autoCompleteTextView.setAdapter(autoCompleteTextViewAdapter)

        binding.autoCompleteTextView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position)

                Toast.makeText(this@ListViewActivity, selectedItem.toString(), Toast.LENGTH_LONG).show()
            }
        }





//list view

        for (i in 0..20) {
            arrayNames.add("Name $i")
        }

        listItemAdapter = ArrayAdapter<String>(
            this@ListViewActivity,
            android.R.layout.simple_list_item_1,
            arrayNames
        )

        binding.listViewNames.adapter = listItemAdapter

        binding.listViewNames.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.d("TAG", "onItemClick: $position, view: $view")
                val selectedItem = parent?.getItemAtPosition(position)

                Log.d("TAG", "onItemClick: selectedItem: ${selectedItem.toString()}")
            }
        }



//search view

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                if (arrayNames.contains(query)) {
                    listItemAdapter.filter.filter(query)
                } else {
                    Toast.makeText(this@ListViewActivity, "No match found", Toast.LENGTH_LONG)
                        .show()
                }

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                listItemAdapter.filter.filter(newText)

                return false
            }
        })
    }
}