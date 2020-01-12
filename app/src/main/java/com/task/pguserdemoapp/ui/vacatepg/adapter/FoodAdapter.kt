package com.task.pguserdemoapp.ui.vacatepg.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.ui.vacatepg.FoodMenuData
import com.task.pguserdemoapp.ui.vacatepg.ResolvedData

class FoodAdapter(var logs: ArrayList<FoodMenuData>) :
    RecyclerView.Adapter<FoodAdapter.UserViewHolder>() {

    fun updateLogs(newLogs: List<FoodMenuData>) {
        logs.clear()
        logs.addAll(newLogs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = UserViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
    )

    override fun getItemCount() = logs.size
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(logs[position])
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        init{

        }

        fun bind(log: FoodMenuData) {


        }
    }
}
