package com.task.pguserdemoapp.ui.registration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.task.pguserdemoapp.MainActivity
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.ActivityUserRegistrationBinding
import com.task.pguserdemoapp.ui.registration.fragment.BasicInfoFragment
import com.task.pguserdemoapp.ui.registration.fragment.EmergencyInfoFragment
import com.task.pguserdemoapp.ui.registration.fragment.IdProofFragment
import kotlinx.android.synthetic.main.activity_user_registration.*

class UserRegistrationActivity : AppCompatActivity() {
    private var regViewModel: RegistrationViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding: ActivityUserRegistrationBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_user_registration)

        binding.lifecycleOwner = this

        regViewModel =
            this.run { ViewModelProviders.of(this).get(RegistrationViewModel::class.java) }

        binding.regViewModel = regViewModel

        getToFragment(BasicInfoFragment())

        basic_info.setOnClickListener {
            getToFragment(BasicInfoFragment())
        }
        emergency_info.setOnClickListener {
            getToFragment(EmergencyInfoFragment())
        }
        regViewModel?.switchBasicInfo?.observe(this, Observer {

            getToFragment(BasicInfoFragment())
        })

        regViewModel?.switchEmergency?.observe(this, Observer {

            getToFragment(EmergencyInfoFragment())
        })

        regViewModel?.switchIdProofPage?.observe(this, Observer {

            getToFragment(IdProofFragment())
        })

        regViewModel?.switchHOmePage?.observe(this, Observer {

            goToHOmePage()
        })

        back_button.setOnClickListener {
            finish()
        }


    }

    private fun goToHOmePage() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun getToFragment(basicInfoFragment: Fragment?) {
        val fragment = basicInfoFragment
        fragment?.let {
            supportFragmentManager.beginTransaction().replace(
                R.id.layout_frame,
                it
            ).commit()
        }
    }


}
