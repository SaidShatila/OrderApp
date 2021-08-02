package com.app.orderapp.entities

import kotlinx.serialization.SerialName

data class Items(
@SerialName("item") val item: String,
@SerialName("quantity") val quantity: Int,
@SerialName("date") val datePicker: String
)