package com.task.pguserdemoapp.ui.vacatepg.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.ui.vacatepg.UnresolvedData

class UnesolvedAdapter(var logs: ArrayList<UnresolvedData>) :
    RecyclerView.Adapter<UnesolvedAdapter.UserViewHolder>() {


    fun updateLogs(newLogs: List<UnresolvedData>) {
        logs.clear()
        logs.addAll(newLogs)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = UserViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.un_resolved_complain_item, parent, false)

    )

    override fun getItemCount() = logs.size
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(logs[position])

    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textViewCategoryName: TextView? = null;
        var textViewCondition: TextView? = null;
        var textViewDescription: TextView? = null;
        var textViewIssueDate : TextView? = null;
        var un_resolvedComplaintEntry: ConstraintLayout? = null

        init {
            textViewCategoryName = itemView.findViewById(R.id.textViewCategoryName)
            textViewCondition = itemView.findViewById(R.id.textViewCondition)
            textViewDescription = itemView.findViewById(R.id.textViewDescription)
            textViewIssueDate = itemView.findViewById(R.id.textViewIssueDate)
            un_resolvedComplaintEntry = itemView.findViewById(R.id.un_resolvedComplaintEntry)
        }

        fun bind(log: UnresolvedData) {
            textViewCondition?.text = log.condition
            textViewCategoryName?.text = log.categoryName
            textViewDescription?.text = log.description
            textViewIssueDate?.text = log.dateTime

            un_resolvedComplaintEntry?.setOnClickListener(View.OnClickListener {

                Log.d("Click","Click")
            })

        }
    }

//    fun replaceFragment(someFragment: Fragment) {
//        val transaction = fragmentManager!!.beginTransaction()
//        transaction.replace(R.id.layout_frame_complaint, someFragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }

}
