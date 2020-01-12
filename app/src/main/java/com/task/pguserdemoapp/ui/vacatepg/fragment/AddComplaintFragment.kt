package com.task.pguserdemoapp.ui.vacatepg.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.FragmentAddComplaintBinding
import com.task.pguserdemoapp.ui.vacatepg.ComplaintData
import com.task.pguserdemoapp.ui.vacatepg.VacateViewModel
import com.task.pguserdemoapp.ui.vacatepg.adapter.ComplaintAdapter


class AddComplaintFragment : Fragment() {
    var vacateViewModel: VacateViewModel ?= null
    var complaintList = ArrayList<ComplaintData>()
    var adapter: ComplaintAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentAddComplaintBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_complaint, container, false)

        binding.lifecycleOwner = this

        vacateViewModel = activity?.run {
            ViewModelProviders.of(this)[VacateViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        binding.fragmentaddComplaint = vacateViewModel

        // Category Complain List
        complaintList.add(ComplaintData("Bedroom",R.drawable.ic_bed))
        complaintList.add(ComplaintData("Washroom",R.drawable.ic_bath))
        complaintList.add(ComplaintData("Food",R.drawable.ic_food_1))
        complaintList.add(ComplaintData("Corridor",R.drawable.ic_corridor_1))
        complaintList.add(ComplaintData("Roommate/staff",R.drawable.ic_angry_1))
        complaintList.add(ComplaintData("Security",R.drawable.ic_cctv_1))

        val gridViewAddComplaint: GridView = binding.root.findViewById(R.id.gridViewAddComplaint)

        adapter = context?.let { ComplaintAdapter(it, complaintList) }
        gridViewAddComplaint.adapter = adapter

        gridViewAddComplaint.setOnItemClickListener { parent, view, position, id ->

            gridViewAddComplaint.numColumns = 3

            val selectedFromList =  complaintList.get(position).name

            addValueToComplaintList(selectedFromList)

            if(!complaintList.isEmpty()){
                adapter = context?.let { ComplaintAdapter(it, complaintList) }
                gridViewAddComplaint.adapter = adapter
            }
        }

         return binding.root

    }

    private fun addValueToComplaintList(selectedFromList: String?) {
        complaintList = ArrayList<ComplaintData>()

        // ic_bedroom ic_complaint list
        if (selectedFromList.equals("Bedroom")){
            complaintList.add(ComplaintData("Lights",R.drawable.ic_light))
            complaintList.add(ComplaintData("Fan",R.drawable.ic_fan))
            complaintList.add(ComplaintData("Switches",R.drawable.ic_switchs))
            complaintList.add(ComplaintData("Bed",R.drawable.ic_bed))
            complaintList.add(ComplaintData("Cupboard",R.drawable.ic_cupboard))
            complaintList.add(ComplaintData("TV",R.drawable.ic_tv))
            complaintList.add(ComplaintData("Door",R.drawable.ic_door))
            complaintList.add(ComplaintData("Wi-Fi",R.drawable.ic_wifi))
            complaintList.add(ComplaintData("Cleaning",R.drawable.ic_cleaning))
            complaintList.add(ComplaintData("Pest Control",R.drawable.ic_tick))
            complaintList.add(ComplaintData("Seepage",R.drawable.ic_leak))
            complaintList.add(ComplaintData("Others",R.drawable.ic_others))

        }
        else if (selectedFromList.equals("Washroom")){
            // washroom ic_complaint List
            complaintList.add(ComplaintData("Lights",R.drawable.ic_light))
            complaintList.add(ComplaintData("Shower",R.drawable.ic_shower))
            complaintList.add(ComplaintData("Taps",R.drawable.ic_tap))
            complaintList.add(ComplaintData("Basin",R.drawable.ic_basin))
            complaintList.add(ComplaintData("Door",R.drawable.ic_door))
            complaintList.add(ComplaintData("Commode",R.drawable.ic_commode))
            complaintList.add(ComplaintData("Seepage",R.drawable.ic_leak))
            complaintList.add(ComplaintData("No water",R.drawable.ic_no_water))
            complaintList.add(ComplaintData("No Hot water",R.drawable.ic_no_hot_water))
            complaintList.add(ComplaintData("Cleaning",R.drawable.ic_cleaning))
            complaintList.add(ComplaintData("Blockage",R.drawable.ic_blockage))
            complaintList.add(ComplaintData("Others",R.drawable.ic_others))

        }
        else if (selectedFromList.equals("Food")) {
            replaceFragment(ComplaintFormFragment())
        }
        else if (selectedFromList.equals("Corridor")){
            // corridor item List
            complaintList.add(ComplaintData("Lights",R.drawable.ic_light))
            complaintList.add(ComplaintData("Lift",R.drawable.ic_lift))
            complaintList.add(ComplaintData("Unclean corridor",R.drawable.ic_dirt))
            complaintList.add(ComplaintData("Lift Lights",R.drawable.ic_tubelight))
            complaintList.add(ComplaintData("Lift fan",R.drawable.ic_fan))
            complaintList.add(ComplaintData("Others",R.drawable.ic_others))

        }
        else if (selectedFromList.equals("Roommate/staff")) {
            replaceFragment(ComplaintFormFragment())
        }
        else if (selectedFromList.equals("Security")){

            // security item list
            complaintList.add(ComplaintData("Cameras",R.drawable.ic_cctv))
            complaintList.add(ComplaintData("Entry/Exit Doors",R.drawable.ic_gate))
            complaintList.add(ComplaintData("Theft",R.drawable.ic_tick))
            complaintList.add(ComplaintData("Others",R.drawable.ic_others))

        }
        else {

            replaceFragment(ComplaintFormFragment())

        }
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