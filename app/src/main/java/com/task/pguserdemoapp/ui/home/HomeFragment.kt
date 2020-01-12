package com.task.pguserdemoapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.ui.adapter.ViewPagerAdapter
import com.task.pguserdemoapp.ui.home.HomeOfferModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var _adapter: ViewPagerAdapter
    private lateinit var offerImageList: ArrayList<HomeOfferModel>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.text.observe(this, Observer {
            //textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        offerImageList = ArrayList()
        offerImageList.add(
            HomeOfferModel(
                1,
                "https://image.flaticon.com/icons/png/512/131/131096.png",
                "",
                true
            )
        )
        offerImageList.add(
            HomeOfferModel(
                2,
                "https://image.flaticon.com/icons/png/512/131/131096.png",
                "",
                true
            )
        )
        offerImageList.add(
            HomeOfferModel(
                3,
                "https://image.flaticon.com/icons/png/512/131/131096.png",
                "",
                true
            )
        )
        _adapter = ViewPagerAdapter(activity!!.supportFragmentManager)
        _adapter.setValue(offerImageList)
        view_pager.adapter = _adapter

    }
}