package com.task.pguserdemoapp.ui.vacatepg.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.FragmentVacatePgInformationBinding
import com.task.pguserdemoapp.ui.vacatepg.VacateViewModel

class VacateInfoFragment : Fragment() {

    private lateinit var vacateInfoViewModel: VacateViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding: FragmentVacatePgInformationBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_vacate_pg_information, container, false)

        vacateInfoViewModel = activity?.run {
            ViewModelProviders.of(this)[VacateViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.vacateViewModel = vacateInfoViewModel


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vacateInfoViewModel?.sendVacateInfoClicked?.observe(this, Observer {

            showDialog(R.layout.dialog_vacate_pg_info,"")
        })

    }

    private fun showDialog(id: Int, title: String) {
        val dialogBuilder = AlertDialog.Builder(getActivity())
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(id, null)
        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(true)
        val b = dialogBuilder.create()

        vacateInfoViewModel?.intimateClicked?.observe(this, Observer {

            showDialog(R.layout.dialog_send,"")
            b.cancel()
        })

        b.show()


    }
}