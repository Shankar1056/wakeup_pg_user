package com.task.pguserdemoapp.ui.vacatepg.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.ui.vacatepg.ResolvedData

class ResolvedAdapter(var logs: ArrayList<ResolvedData>) :
    RecyclerView.Adapter<ResolvedAdapter.UserViewHolder>() {

    fun updateLogs(newLogs: List<ResolvedData>) {
        logs.clear()
        logs.addAll(newLogs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = UserViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.resolved_complain_item, parent, false)
    )

    override fun getItemCount() = logs.size
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(logs[position])
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewResolvedComplain: TextView? = null
        var textViewResolvedBy: TextView? = null
        var textViewComplaintDescription: TextView? = null
        var textViewIssueDate: TextView? = null

        init{
            textViewResolvedComplain        = itemView.findViewById(R.id.textViewResolvedComplain)
            textViewResolvedBy              = itemView.findViewById(R.id.textViewResolvedBy)
            textViewComplaintDescription    = itemView.findViewById(R.id.textViewComplaintDescription)
            textViewIssueDate               = itemView.findViewById(R.id.textViewIssueDate)
        }

        fun bind(log: ResolvedData) {
            textViewResolvedComplain?.text = log.resolvedComplain
            textViewResolvedBy?.text = log.resolvedBy
            textViewComplaintDescription?.text = log.complainDescription
            textViewIssueDate?.text = log.issueDate

        }
    }
}
