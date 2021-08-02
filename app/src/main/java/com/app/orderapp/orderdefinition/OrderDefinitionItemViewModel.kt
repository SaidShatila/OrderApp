package com.app.orderapp.orderdefinition

import android.widget.DatePicker
import android.widget.Spinner
import androidx.lifecycle.ViewModel
import com.app.orderapp.entities.Items

class OrderDefinitionItemViewModel(
//    val items: List<Items>,
    spinner: Spinner,
    spinner2: Spinner,
    datePicker: DatePicker,
) : ViewModel() {

    val itemSpinner= spinner.selectedItem.toString()
    val itemQuantity= spinner2.selectedItem.toString()
    val datePickerText = datePicker.dayOfMonth.toString() + datePicker.month.toString() + datePicker.year.toString()





}
