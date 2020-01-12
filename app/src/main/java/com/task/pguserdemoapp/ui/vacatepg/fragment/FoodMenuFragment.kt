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
import com.task.pguserdemoapp.databinding.FragmentVacateResolvedBinding
import com.task.pguserdemoapp.databinding.FregmentFoodBinding
import com.task.pguserdemoapp.ui.vacatepg.FoodMenuData


import com.task.pguserdemoapp.ui.vacatepg.VacateViewModel
import com.task.pguserdemoapp.ui.vacatepg.adapter.ResolvedAdapter
import kotlinx.android.synthetic.main.fragment_vacate_resolved.*

class FoodMenuFragment : Fragment() {
    var vacateViewModel: VacateViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FregmentFoodBinding =
            DataBindingUtil.inflate(inflater, R.layout.fregment_food, container, false)

        vacateViewModel = activity?.run {
            ViewModelProviders.of(this)[VacateViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.vacateViewModel = vacateViewModel

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    fun replaceFragment(someFragment: Fragment) {
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.layout_frame_complaint, someFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}