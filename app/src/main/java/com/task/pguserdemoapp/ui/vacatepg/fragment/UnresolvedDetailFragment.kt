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
import com.task.pguserdemoapp.databinding.FragmentComplaintUnresolveDetailBinding
import com.task.pguserdemoapp.databinding.FragmentVacateResolvedBinding
import com.task.pguserdemoapp.databinding.FragmentVacateUnresolvedBinding
import com.task.pguserdemoapp.ui.vacatepg.UnresolvedData
import com.task.pguserdemoapp.ui.vacatepg.VacateViewModel
import com.task.pguserdemoapp.ui.vacatepg.adapter.UnesolvedAdapter
import kotlinx.android.synthetic.main.fragment_vacate_unresolved.*

class UnresolvedDetailFragment : Fragment() {
    var vacateViewModel: VacateViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentComplaintUnresolveDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_complaint_unresolve_detail, container, false)

        vacateViewModel = activity?.run {
            ViewModelProviders.of(this)[VacateViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.vacateViewModel = vacateViewModel
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }


}