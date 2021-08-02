package com.app.orderapp.user

import android.content.Intent
import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.orderapp.R
import com.app.orderapp.databinding.UserLoginPageBinding
import com.app.orderapp.orderdefinition.OrderDefinitionActivity
import com.app.orderapp.utils.CustomeProgressDialog


class LoginActivity : AppCompatActivity() {

    var binding: UserLoginPageBinding? = null
    var viewmodel: UserLoginViewModel? = null
    var customeProgressDialog: CustomeProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.user_login_page)
        viewmodel = ViewModelProvider(this).get(UserLoginViewModel::class.java)
        binding?.viewModel = viewmodel
        customeProgressDialog = CustomeProgressDialog(this)
        initObservables()


    }

    private fun initObservables() {
        viewmodel?.progressDialog?.observe(this, Observer {
            if (it!!) customeProgressDialog?.show() else customeProgressDialog?.dismiss()
        })

        viewmodel?.userLogin?.observe(this, Observer { user ->
            Toast.makeText(this, "welcome, ${user?.email}", Toast.LENGTH_LONG).show()
            val intent = Intent(this, OrderDefinitionActivity::class.java).apply {
            }
            startActivity(intent)
        })
    }


}