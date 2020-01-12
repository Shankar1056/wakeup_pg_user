package com.task.pguserdemoapp.ui.vacatepg.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.ui.lateentry.LateEntryLogData
import com.task.pguserdemoapp.ui.vacatepg.VisitorLogData

class VisitorLogsAdapter(var logs: ArrayList<VisitorLogData>) :
    RecyclerView.Adapter<VisitorLogsAdapter.UserViewHolder>() {

    fun updateLogs(newLogs: List<VisitorLogData>) {
        logs.clear()
        logs.addAll(newLogs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = UserViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.visitor_logs_item, parent, false)
    )

    override fun getItemCount() = logs.size
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(logs[position])
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var textViewLogVisitorName: TextView? = null;
        private var textViewDate: TextView? = null;
        private var textViewLoginTime : TextView? = null;
        private var textViewLogOutTime : TextView? = null;
        private var imageViewLogPhoto: ImageView? = null;
        private var imageViewLogout: ImageView? = null;
        init {
            textViewLogVisitorName = itemView.findViewById(R.id.textViewLogVisitorName)
            textViewDate = itemView.findViewById(R.id.textViewDate)
            textViewLoginTime = itemView.findViewById(R.id.textViewLoginTime)
            textViewLogOutTime = itemView.findViewById(R.id.textViewLogoutTkime)
            imageViewLogPhoto = itemView.findViewById(R.id.imageViewLogPhoto)
            imageViewLogout = itemView.findViewById(R.id.imageViewLogout)
        }
        fun bind(log: VisitorLogData) {
            textViewLogVisitorName?.text = log.visitorName
            textViewDate?.text = log.date
            textViewLoginTime?.text = "Log In - "+ log.loginTime
            textViewLogOutTime?.text = "Log Out - "+ log.logOutTIme
            imageViewLogout?.isEnabled = !log.isLogout
            Glide.with(itemView).load(log.photoUrl).into(imageViewLogPhoto!!)
        }
    }
}
