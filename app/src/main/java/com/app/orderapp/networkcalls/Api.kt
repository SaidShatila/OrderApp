package com.app.orderapp.networkcalls

import com.app.orderapp.entities.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("auth/login")
    fun LOGIN(@Field("userEmail") email: String, @Field("userPassowrd") password: String): Call<User>

}
