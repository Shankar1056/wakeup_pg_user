package com.task.pguserdemoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import com.task.pguserdemoapp.BR
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.HomeOfferListBinding

import com.task.pguserdemoapp.ui.home.HomeOfferModel


class HomeOfferAdapter(
    private val imageList: ArrayList<HomeOfferModel>
) :
    RecyclerView.Adapter<HomeOfferAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var binding: HomeOfferListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.home_offer_list, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = imageList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val offerModel = imageList[position]
        holder.bind(offerModel)
    }


    inner class ViewHolder(val itemRowBinding: HomeOfferListBinding) :
        RecyclerView.ViewHolder(itemRowBinding.getRoot()) {

        fun bind(obj: Any) {
            itemRowBinding.setVariable(BR.offerImageList, obj)
            itemRowBinding.executePendingBindings()
        }

    }

    interface OnShopItemClickListener {
        fun onClick(pos: Int)
    }


}