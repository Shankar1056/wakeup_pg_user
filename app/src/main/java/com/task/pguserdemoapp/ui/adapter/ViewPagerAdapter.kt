package com.task.pguserdemoapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.task.pguserdemoapp.ui.home.HomeOfferModel
import com.task.pguserdemoapp.ui.home.ViewOfferFragment
import java.util.*

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    var imageList = ArrayList<HomeOfferModel>()
    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return ViewOfferFragment(imageList)
        }
        return null
    }

    override fun getCount(): Int {
        return 1
    }

    fun setValue(offerImageList: ArrayList<HomeOfferModel>) {
        imageList = offerImageList
    }


}