package com.app.orderapp.orderdefinition

import android.app.Application
import android.widget.DatePicker
import android.widget.Spinner
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.app.orderapp.R
import com.app.orderapp.entities.Items
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderDefinitionActivityViewModel(
    application: Application

) : AndroidViewModel(application), Callback<Items> {

var applyButton: ObservableBoolean? = null
var itemSelected: MutableLiveData<Spinner>? = null
var itemQuantity: ObservableField<Spinner>? = null
var itemDate: ObservableField<DatePicker>? = null
var itemsList: MutableLiveData<Items>? = null
init {
    applyButton = ObservableBoolean(true)
    itemSelected = MutableLiveData()
    itemQuantity = ObservableField()
    itemDate = ObservableField()
    itemsList = MutableLiveData<Items>()

}


override fun onResponse(call: Call<Items>, response: Response<Items>) {

}

override fun onFailure(call: Call<Items>, t: Throwable) {
    TODO("Not yet implemented")
}

}