package com.task.pguserdemoapp.ui.vacatepg.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.ui.vacatepg.ComplaintData
import kotlinx.android.synthetic.main.complaint_item.view.*

class ComplaintAdapter : BaseAdapter {
    var complainList = ArrayList<ComplaintData>()
    var context: Context? = null

    constructor(context: Context, complainList: ArrayList<ComplaintData>) : super() {
        this.context = context
        this.complainList = complainList
    }

    override fun getCount(): Int {
        return complainList.size
    }

    override fun getItem(position: Int): Any {
        return complainList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val complain = this.complainList[position]

        var inflator =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var foodView = inflator.inflate(R.layout.complaint_item, null)
        foodView.imageViewComplaint.setImageResource(complain.image!!)
        foodView.textViewComplaintName.text = complain.name!!

        return foodView
    }
}