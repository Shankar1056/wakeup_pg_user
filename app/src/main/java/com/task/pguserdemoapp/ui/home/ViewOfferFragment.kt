package com.task.pguserdemoapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.pguserdemoapp.R

import com.task.pguserdemoapp.ui.adapter.HomeOfferAdapter
import com.task.pguserdemoapp.ui.home.HomeOfferModel
import kotlinx.android.synthetic.main.fragment_view_offer.*
import java.util.*


class ViewOfferFragment(val imageList: ArrayList<HomeOfferModel>) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_offer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_common.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        rv_common.adapter =  HomeOfferAdapter(imageList)


    }
}