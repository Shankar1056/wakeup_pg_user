package com.task.pguserdemoapp.ui.vacatepg.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.FragmentVacateComplaintBinding
import com.task.pguserdemoapp.databinding.FragmentVacateResolvedBinding
import com.task.pguserdemoapp.ui.vacatepg.ResolvedData


import com.task.pguserdemoapp.ui.vacatepg.VacateViewModel
import com.task.pguserdemoapp.ui.vacatepg.adapter.ResolvedAdapter
import kotlinx.android.synthetic.main.fragment_vacate_resolved.*

class ResolvedFragment : Fragment() {
    var vacateViewModel: VacateViewModel? = null

    var resolvedData : ArrayList<ResolvedData> = ArrayList<ResolvedData>()

    init{
        var resolvedData1 = ResolvedData()
        resolvedData1.resolvedComplain = "Unclean room"
        resolvedData1.resolvedBy ="Lakshamma"
        resolvedData1.complainDescription ="Room cleaned"
        resolvedData1.issueDate =" 30 Jun 19 10:00 AM"
        resolvedData.add(resolvedData1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentVacateResolvedBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_vacate_resolved, container, false)

        vacateViewModel = activity?.run {
            ViewModelProviders.of(this)[VacateViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.fragmentResolved = vacateViewModel

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vacateViewModel?.switchTocomplainScreen?.observe(this, Observer {
            replaceFragment(AddComplaintFragment())
        })
        recyclerViewResolved.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ResolvedAdapter(resolvedData)
        }
    }

    fun replaceFragment(someFragment: Fragment) {
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.layout_frame_complaint, someFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}