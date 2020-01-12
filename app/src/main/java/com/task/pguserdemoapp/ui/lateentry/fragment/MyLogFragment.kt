package com.task.pguserdemoapp.ui.lateentry.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.FragmentMyLogBinding

import com.task.pguserdemoapp.ui.lateentry.LateEntryViewModel


class MyLogFragment : Fragment() {


    var lateEntryViewModel: LateEntryViewModel? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentMyLogBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_my_log, container, false)

        lateEntryViewModel = activity?.run {
            ViewModelProviders.of(this)[LateEntryViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.fragmentMyLog = lateEntryViewModel
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}
