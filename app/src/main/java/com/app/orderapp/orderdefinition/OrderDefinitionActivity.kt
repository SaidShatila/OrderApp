package com.app.orderapp.orderdefinition

import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.app.orderapp.R
import com.app.orderapp.adapters.ItemsListAdapter
import com.google.android.material.navigation.NavigationView

class OrderDefinitionActivity : AppCompatActivity() {
//    var binding: OrderDefinitionBinding? = null
//    var viewmodel: OrderDefinitionActivityViewModel? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.order_definition)
//        viewmodel = ViewModelProvider(this).get(OrderDefinitionActivityViewModel::class.java)
//        binding?.viewModel = viewmodel

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_definition)
        val spinner: Spinner = findViewById(R.id.spinner_item)
        val spinner2: Spinner = findViewById(R.id.spinner_item_quantity)
        val datePicker: DatePicker = findViewById(R.id.date_Picker)
        val applyButton: Button = findViewById(R.id.apply_button)
        setSupportActionBar(findViewById(R.id.toolbar))
        val navigation_view: NavigationView = findViewById(R.id.navigation_view)
        val drawer: DrawerLayout = findViewById(R.id.drawer)
        val toolbar : Toolbar  = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        onBackPressed()

        navigation_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    true
                }
            }
            true
        }

        val drawerToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        fun onBackPressed() {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }

        fun onOptionsItemSelected(item: MenuItem): Boolean {
            super.onOptionsItemSelected(item)
            return when (item.itemId) {
                android.R.id.home -> {
                    drawer.openDrawer(GravityCompat.START)
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
        }


        spinnerFunctionality(spinner, spinner2)


    }

    fun applyButtonPressed(
        applyButton: Button,
        spinner: Spinner,
        spinner2: Spinner,
        datePicker: DatePicker

    ) {
        applyButton.setOnClickListener(View.OnClickListener {
            val itemSpinner = spinner.selectedItem.toString()
            val itemQuantity = spinner2.selectedItem.toString()
            val datePickerText =
                datePicker.dayOfMonth.toString() + datePicker.month.toString() + datePicker.year.toString()
            val items = listOf(itemSpinner, itemQuantity, datePickerText)


            val adapter = ItemsListAdapter(items = listOf())

        })
    }


    fun navigationDrawer() {


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