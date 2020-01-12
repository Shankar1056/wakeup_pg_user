package com.task.pguserdemoapp.ui.lateentry.fragment

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.LateEntryFragmentBinding
import com.task.pguserdemoapp.ui.lateentry.LateEntryViewModel
import com.task.pguserdemoapp.ui.vacatepg.VacatePgActivity
import kotlinx.android.synthetic.main.fragment_mobile_number.*
import kotlinx.android.synthetic.main.late_entry_fragment.*


class LateEntryFragment : Fragment() {

    var lateEntryViewModel: LateEntryViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: LateEntryFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.late_entry_fragment, container, false)

        lateEntryViewModel = activity?.run {
            ViewModelProviders.of(this)[LateEntryViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.fragmentLateEntry = lateEntryViewModel


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        buttonSend.setOnClickListener {
//            Log.d("btnSetup", "Selected")
//        }

        lateEntryViewModel?.sendButtonClicked?.observe(this, Observer {

            val intent = Intent (getActivity(), VacatePgActivity::class.java)
            getActivity()?.startActivity(intent)
        })

    }

}



