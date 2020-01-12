package com.task.pguserdemoapp.ui.vacatepg.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.FragmentVacateComplaintBinding
import com.task.pguserdemoapp.ui.vacatepg.VacateViewModel

class VacateComplaintFragment : Fragment() {
    var vacateViewModel: VacateViewModel? = null
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentVacateComplaintBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_vacate_complaint, container, false)

        binding.lifecycleOwner = this

        vacateViewModel = activity?.run {
            ViewModelProviders.of(this)[VacateViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.complaintViewModel = vacateViewModel

        vacateViewModel?.switchResolved?.observe(this, Observer {
            replaceFragment(ResolvedFragment())

        })

        vacateViewModel?.switchUnresolved?.observe(this, Observer {

            replaceFragment(UnresolvedFragment())

        })


         return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        replaceFragment(UnresolvedFragment())

    }



    fun replaceFragment(someFragment: Fragment) {
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.layout_frame_vacate_complain, someFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}