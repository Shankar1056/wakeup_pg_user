package com.task.pguserdemoapp.ui.registration.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.FragmentBasicInfoBinding
import com.task.pguserdemoapp.ui.registration.RegistrationViewModel
import com.task.pguserdemoapp.utilz.Utility
import kotlinx.android.synthetic.main.fragment_basic_info.*


class BasicInfoFragment : Fragment() {

    var userRegViewModel: RegistrationViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentBasicInfoBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_basic_info, container, false)
        userRegViewModel = activity?.run {
            ViewModelProviders.of(this)[RegistrationViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.fragmentBasicInfo = userRegViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        avi.show()
        spinner_age.setOnClickListener {
            activity?.let { it1 -> userRegViewModel!!.getDateCalender(true, it1) }
        }
        date_of_joining.setOnClickListener {
            activity?.let { it1 -> userRegViewModel!!.getDateCalender(false, it1) }
        }

        userRegViewModel!!.dob.observe(this, Observer {
            spinner_age.text = it

        })
        userRegViewModel!!.doj.observe(this, Observer {
            date_of_joining.text = it

        })

        userRegViewModel!!.inputErrorMessage.observe(this, Observer {
            Utility.showToast(activity, it)
        })

        userRegViewModel!!.showProgressDialog.observe(this, Observer {
            if (it) avi.show()
            else avi.hide()
        })
        userRegViewModel!!.onResponseMessage.observe(this, Observer {
            Utility.showToast(activity, it)
        })
    }

}