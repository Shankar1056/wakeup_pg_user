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
import androidx.recyclerview.widget.RecyclerView
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.FragmentLogsBinding
import com.task.pguserdemoapp.databinding.FragmentVacateResolvedBinding
import com.task.pguserdemoapp.databinding.FragmentVacateUnresolvedBinding
import com.task.pguserdemoapp.ui.lateentry.LateEntryLogData
import com.task.pguserdemoapp.ui.lateentry.adapter.LateEntryLogAdapter
import com.task.pguserdemoapp.ui.vacatepg.VacateViewModel
import com.task.pguserdemoapp.ui.vacatepg.VisitorLogData
import com.task.pguserdemoapp.ui.vacatepg.adapter.VisitorLogsAdapter
import kotlinx.android.synthetic.main.fragment_logs.*

class LogsFragment : Fragment() {
    var vacateViewModel: VacateViewModel? = null
    var tempLogData: ArrayList<VisitorLogData> = ArrayList<VisitorLogData>()
    init{
        var logEntry = VisitorLogData()
        logEntry.visitorName ="John"
        logEntry.date =" 19th June"
        logEntry.isLogout = true
        logEntry.loginTime ="5 pm"
        logEntry.logOutTIme = "7 pm"

        tempLogData.add(logEntry)
        tempLogData.add(logEntry)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentLogsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_logs, container, false)

        vacateViewModel = activity?.run {
            ViewModelProviders.of(this)[VacateViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.vacateViewModel = vacateViewModel

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewLogs.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = VisitorLogsAdapter(tempLogData)
        }
    }
}