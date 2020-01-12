package com.task.pguserdemoapp.ui.vacatepg.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.ui.vacatepg.VacateViewModel


class VacateHomeFragment : Fragment() {

    private lateinit var vacateViewModel: VacateViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vacateViewModel =
            ViewModelProviders.of(this).get(VacateViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_vacate_home, container, false)
        val textView: TextView = root.findViewById(R.id.textViewVacateHome)

        return root
    }
}