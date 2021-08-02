package com.app.sqlitetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.sqlitetest.user.UserInsertFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) { // initial transaction should be wrapped like this
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, UserInsertFragment())
                .commitAllowingStateLoss()
        }

    }
}