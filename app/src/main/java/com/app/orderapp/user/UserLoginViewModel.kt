package com.app.orderapp.user

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.AndroidViewModel
import com.app.orderapp.entities.User
import com.app.orderapp.networkcalls.Api
import com.app.orderapp.networkcalls.WebServiceClient
import com.app.orderapp.utils.SingleLiveEvent
import com.app.orderapp.utils.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserLoginViewModel(application: Application) : AndroidViewModel(application), Callback<User> {
    var btnSelected: ObservableBoolean? = null
    var email: ObservableField<String>? = null
    var password: ObservableField<String>? = null
    var progressDialog: SingleLiveEvent<Boolean>? = null
    var userLogin: MutableLiveData<User>? = null

    init {
        btnSelected = ObservableBoolean(false)
        progressDialog = SingleLiveEvent<Boolean>()
        email = ObservableField("")
        password = ObservableField("")
        userLogin = MutableLiveData<User>()
    }

    fun onEmailChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        btnSelected?.set(Util.isEmailValid(s.toString()) && password?.get()!!.length >= 8)


    }

    fun onPasswordChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        btnSelected?.set(Util.isEmailValid(email?.get()!!) && s.toString().length >= 8)


    }

    fun login() {
        progressDialog?.value = true
        WebServiceClient.client.create(Api::class.java).LOGIN(email = email?.get()!!
            , password = password?.get()!!)
            .enqueue(this)
    }

    override fun onResponse(call: Call<User>?, response: Response<User>?) {
        progressDialog?.value = false
        userLogin?.value = response?.body()

    }

    override fun onFailure(call: Call<User>?, t: Throwable?) {
        progressDialog?.value = false

    }
}