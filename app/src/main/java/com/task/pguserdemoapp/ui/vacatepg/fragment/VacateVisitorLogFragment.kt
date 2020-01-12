package com.task.pguserdemoapp.ui.vacatepg.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.FragmentVacateComplaintBinding
import com.task.pguserdemoapp.databinding.FragmentVacateVisitorLogBinding
import com.task.pguserdemoapp.ui.vacatepg.VacateViewModel



class VacateVisitorLogFragment : Fragment() {
    var vacateViewModel: VacateViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentVacateVisitorLogBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_vacate_visitor_log, container, false)

        binding.lifecycleOwner = this

        vacateViewModel = activity?.run {
            ViewModelProviders.of(this)[VacateViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.vacateViewModel = vacateViewModel

        vacateViewModel?.switchRegister?.observe(this, Observer {
            replaceFragment(RegisterFragment())

        })

        vacateViewModel?.switchVisitorLog?.observe(this, Observer {

            replaceFragment(LogsFragment())

        })


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        replaceFragment(RegisterFragment())

    }
    fun replaceFragment(someFragment: Fragment) {
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.layout_frame_visitor_log, someFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}