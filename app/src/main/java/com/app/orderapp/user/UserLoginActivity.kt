package com.app.orderapp.user

import android.content.Intent
import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.orderapp.R
import com.app.orderapp.databinding.UserLoginPageBinding
import com.app.orderapp.orderdefinition.OrderDefinitionActivity
import com.app.orderapp.utils.CustomeProgressDialog


class LoginActivity : AppCompatActivity() {

    private var binding: UserLoginPageBinding? = null
    var viewModel: UserLoginViewModel? = null
    private var customProgressDialog: CustomeProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.user_login_page)
        viewModel = ViewModelProvider(this).get(UserLoginViewModel::class.java)
        binding?.viewModel = viewModel
        customProgressDialog = CustomeProgressDialog(this)
        initObservables()


    }

    private fun initObservables() {
        viewModel?.progressDialog?.observe(this, {
            if (it!!) customProgressDialog?.show() else customProgressDialog?.dismiss()
        })

        viewModel?.userLogin?.observe(this, { user ->
            Toast.makeText(this, "welcome, ${user?.email}", Toast.LENGTH_LONG).show()
            val intent = Intent(this, OrderDefinitionActivity::class.java).apply {
            }
            startActivity(intent)
        })
    }


}