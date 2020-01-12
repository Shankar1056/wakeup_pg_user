package com.task.pguserdemoapp.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.ui.login.fragment.MobileNumberFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginFragment()
    }

    private fun loginFragment() {
        val fragment = MobileNumberFragment()
        supportFragmentManager.beginTransaction().replace(R.id.layout_frame, fragment).commit()
    }


}