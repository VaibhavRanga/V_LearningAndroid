package com.vaibhavranga.v_learningandroid

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vaibhavranga.v_learningandroid.databinding.ActivityDateTimeBinding

class DateTimeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDateTimeBinding
    private lateinit var selectedDateAndTime: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDateTimeBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonDate.setOnClickListener {
            val myCalendar = Calendar.getInstance()

            selectedDateAndTime = Calendar.getInstance()

            val year = myCalendar.get(Calendar.YEAR)
            val month = myCalendar.get(Calendar.MONTH)
            val dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this@DateTimeActivity, object : OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    selectedDateAndTime.set(Calendar.YEAR, p1)
                    selectedDateAndTime.set(Calendar.MONTH, p2)
                    selectedDateAndTime.set(Calendar.DAY_OF_MONTH, p3)

                    val dateFormat = SimpleDateFormat("dd-MM-yyyy, hh:mm a")
                    val date = dateFormat.format(selectedDateAndTime.timeInMillis)
                    binding.textView.text = date
//                    binding.textView.text = selectedDateAndTime.timeInMillis.toString()
                }
            }, year, month, dayOfMonth).show()
        }

        binding.buttonTime.setOnClickListener {
            val myCalendar = Calendar.getInstance()

            selectedDateAndTime = Calendar.getInstance()

            val hourOfDay = myCalendar.get(Calendar.HOUR_OF_DAY)
            val minute = myCalendar.get(Calendar.MINUTE)

            TimePickerDialog(this@DateTimeActivity, object : OnTimeSetListener {
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    selectedDateAndTime.set(Calendar.HOUR_OF_DAY, p1)
                    selectedDateAndTime.set(Calendar.MINUTE, p2)

                    val dateFormat = SimpleDateFormat.getTimeInstance()
                    val time = dateFormat.format(selectedDateAndTime.timeInMillis)
                    binding.textView.text = time
//                    binding.textView.text = selectedDateAndTime.timeInMillis.toString()
                }
            }, hourOfDay, minute, false).show()
        }
    }
}