package com.app.orderapp.entities

import kotlinx.serialization.SerialName

data class User(
    @SerialName("userEmail") val email: String,
    @SerialName("userPassowrd") val password: String

)
