package com.task.pguserdemoapp.ui.lateentry.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.ui.lateentry.LateEntryLogData
import org.w3c.dom.Text

class LateEntryLogAdapter(var logs: ArrayList<LateEntryLogData>) :
    RecyclerView.Adapter<LateEntryLogAdapter.UserViewHolder>() {

    fun updateLogs(newLogs: List<LateEntryLogData>) {
        logs.clear()
        logs.addAll(newLogs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = UserViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.late_entry_log_item, parent, false)
    )

    override fun getItemCount() = logs.size
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(logs[position])
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(log: LateEntryLogData) {

        }
    }
}
