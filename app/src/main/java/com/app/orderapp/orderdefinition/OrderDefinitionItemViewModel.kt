package com.app.orderapp.orderdefinition

import androidx.lifecycle.ViewModel
import com.app.orderapp.entities.Items

class OrderDefinitionItemViewModel(
    val itemsList: Items

) : ViewModel() {
    val itemSelected = itemsList.item
    val quantitySelected = itemsList.quantity.toString()
    val dateSelected = itemsList.datePicker

}
