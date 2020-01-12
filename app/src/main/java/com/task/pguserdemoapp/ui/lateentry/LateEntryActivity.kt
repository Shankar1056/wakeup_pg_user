package com.task.pguserdemoapp.ui.lateentry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.Observer
import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.LateEntryActivityBinding
import com.task.pguserdemoapp.ui.lateentry.fragment.LateEntryFragment
import com.task.pguserdemoapp.ui.lateentry.fragment.MyLogFragment
import com.task.pguserdemoapp.ui.vacatepg.VacatePgActivity
import kotlinx.android.synthetic.main.late_entry_activity.*

class LateEntryActivity : AppCompatActivity() {

    private var lateViewModel: LateEntryViewModel?= null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var binding: LateEntryActivityBinding =
            DataBindingUtil.setContentView(this,
                R.layout.late_entry_activity
            )

        binding.lifecycleOwner = this

        lateViewModel =
            this.run { ViewModelProviders.of(this).get(LateEntryViewModel::class.java) }

        binding.lateViewModel = lateViewModel

            lateViewModel?.sendButtonEnable?.observe(this, Observer {
            Log.d("SendButton", it.toString())
        })


        getToFragment(MyLogFragment())


        textViewNewTab.setOnClickListener {
            getToFragment(LateEntryFragment())
        }

        textViewMyLogs.setOnClickListener(){
           getToFragment(MyLogFragment())
        }


        lateViewModel?.switchLateEntry?.observe(this, Observer {

            getToFragment(LateEntryFragment())
        })

        lateViewModel?.switchMyLog?.observe(this, Observer {

            getToFragment(MyLogFragment())
        })

    }


    fun getToFragment(LateEntryFragment: Fragment?) {
        val fragment = LateEntryFragment
        fragment?.let {
            supportFragmentManager.beginTransaction().replace(
                R.id.layout_frame,
                it
            ).commit()
        }
    }



}
