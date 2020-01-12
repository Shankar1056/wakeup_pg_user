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
import com.task.pguserdemoapp.databinding.FragmentVacateUnresolvedBinding
import com.task.pguserdemoapp.ui.vacatepg.UnresolvedData
import com.task.pguserdemoapp.ui.vacatepg.VacateViewModel
import com.task.pguserdemoapp.ui.vacatepg.adapter.UnesolvedAdapter
import kotlinx.android.synthetic.main.fragment_vacate_unresolved.*

class UnresolvedFragment : Fragment() {
    var vacateViewModel: VacateViewModel? = null
    var unresolvedComplaints: ArrayList<UnresolvedData> = ArrayList<UnresolvedData>()

    init{
        var complaint1 = UnresolvedData()
        var complaint2 = UnresolvedData()
        complaint1.categoryName = "Light"
        complaint2.categoryName = "Pest"
        complaint1.condition ="Not working"
        complaint2.condition ="Working"
        complaint1.description = "Tubelight has burnt.."
        complaint2.description = "bed bugs on mattress"
        complaint1.dateTime =" 29 Jun 19 6:23 PM"
        complaint2.dateTime =" 29 Jun 19 6:23 PM"
        unresolvedComplaints.add(complaint1)
        unresolvedComplaints.add(complaint2)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentVacateUnresolvedBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_vacate_unresolved, container, false)

        vacateViewModel = activity?.run {
            ViewModelProviders.of(this)[VacateViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.fragmentUnResolved = vacateViewModel
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vacateViewModel?.switchTocomplainScreen?.observe(this, Observer {
            replaceFragment(AddComplaintFragment())
        })
        recyclerViewUnresolved.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = UnesolvedAdapter(unresolvedComplaints)
        }
        
    }

    fun replaceFragment(someFragment: Fragment) {
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.layout_frame_complaint, someFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}