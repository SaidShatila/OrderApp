package com.app.orderapp.orderdefinition

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.orderapp.R
import com.app.orderapp.entities.Items


class OrderDefinitionActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_definition)
        val spinner: Spinner = findViewById(R.id.spinner_item)
        val spinner2: Spinner = findViewById(R.id.spinner_item_quantity)
        val datePicker: DatePicker = findViewById(R.id.date_Picker)
        val applyButton: Button = findViewById(R.id.apply_button)

        spinnerFunctionality(spinner, spinner2)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                Toast.makeText(
                    this@OrderDefinitionActivity,
                    R.array.planets_array.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

        fun applyButtonPressed(
            applyButton: Button,
            spinner: Spinner,
            spinner2: Spinner,
            datePicker: DatePicker
        ) {
            applyButton.setOnClickListener(View.OnClickListener {
                val itemSpinner= spinner.selectedItem.toString()
                val itemQuantity= spinner2.selectedItem.toString()
                val datePickerText = datePicker.dayOfMonth.toString() + datePicker.month.toString() + datePicker.year.toString()



            })
        }




    fun spinnerFunctionality(spinner: Spinner, spinner2: Spinner) {
            // Create an ArrayAdapter
            val adapterItem = ArrayAdapter.createFromResource(
                this,
                R.array.planets_array, android.R.layout.simple_spinner_item
            )
            // Specify the layout to use when the list of choices appears
            adapterItem.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner

            val adapterQuantity = ArrayAdapter.createFromResource(
                this,
                R.array.quantity, android.R.layout.simple_spinner_item
            )
            // Specify the layout to use when the list of choices appears
            adapterQuantity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner.adapter = adapterItem
            spinner2.adapter = adapterQuantity

        }
}