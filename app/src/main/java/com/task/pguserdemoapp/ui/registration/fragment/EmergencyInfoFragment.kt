package com.task.pguserdemoapp.ui.registration.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.FragmentEmergencyInfoFragmentBinding
import com.task.pguserdemoapp.ui.registration.RegistrationViewModel

class EmergencyInfoFragment : Fragment() {
    var userRegViewModel: RegistrationViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding: FragmentEmergencyInfoFragmentBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_emergency_info_fragment,
                container,
                false
            )
        userRegViewModel = activity?.run {
            ViewModelProviders.of(this)[RegistrationViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.emergencyViewModel = userRegViewModel
        return binding.root
    }
}