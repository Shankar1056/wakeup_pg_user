package com.task.pguserdemoapp.ui.vacatepg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.task.pguserdemoapp.R
import com.task.pguserdemoapp.databinding.ActivityVacatePgBinding
import com.task.pguserdemoapp.ui.vacatepg.fragment.VacateComplaintFragment
import com.task.pguserdemoapp.ui.vacatepg.fragment.VacateHomeFragment
import com.task.pguserdemoapp.ui.vacatepg.fragment.VacateInfoFragment
import com.task.pguserdemoapp.ui.vacatepg.fragment.VacateVisitorLogFragment

class VacatePgActivity : AppCompatActivity() {

    private var vacateViewModel: VacateViewModel?= null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getSupportActionBar()?.hide();
        var binding: ActivityVacatePgBinding =
            DataBindingUtil.setContentView(this,
                R.layout.activity_vacate_pg
            )

        binding.lifecycleOwner = this

        vacateViewModel =
            this.run { ViewModelProviders.of(this).get(VacateViewModel::class.java) }

        binding.vacateViewModel = vacateViewModel

        val navView: BottomNavigationView = findViewById(R.id.nav_view_vacate)

        val navController = findNavController(R.id.nav_host_fragment)

        // Passing each ic_menu ID as a set of Ids because each
        // ic_menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_vacate_home, R.id.navigation_vacate_my_complaints,
                R.id.navigation_vacate_visitor_log, R.id.navigation_vacate_info
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setOnNavigationItemSelectedListener(myOnNavigationItemSelectedListener)
    }

    private val myOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val imageViewVacateMenu: ImageView = findViewById(R.id.imageViewVacateMenu)
        val textViewVacatePg: TextView = findViewById(R.id.textViewVacatePg)
        when (item.itemId) {
            R.id.navigation_vacate_home -> {
                imageViewVacateMenu.setImageResource(R.drawable.ic_menu)
                textViewVacatePg.setText(R.string.title_home)
                openFragment(VacateHomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_vacate_my_complaints -> {
                imageViewVacateMenu.setImageResource(R.drawable.ic_menu)
                textViewVacatePg.setText("Complaint")
                openFragment(VacateComplaintFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_vacate_visitor_log -> {
                imageViewVacateMenu.setImageResource(R.drawable.ic_menu)
                textViewVacatePg.setText(R.string.title_visitor_log)
                openFragment(VacateVisitorLogFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_vacate_info -> {
                imageViewVacateMenu.setImageResource(R.drawable.ic_menu)
                textViewVacatePg.setText(R.string.title_vacate)
                openFragment(VacateInfoFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
