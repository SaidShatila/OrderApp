package com.app.orderapp.model

import kotlin.random.Random

class UserModel(val id: Int, val name: String = "", val email : String = "",val password : String = "") {

    companion object {
        fun getId(): Int {
            val random = Random
            return random.nextInt(100)

        }
    }
}