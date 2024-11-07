package com.example.byterisk_mobile_2tdpr.utils

import android.content.Context
import android.content.Intent
import com.example.byterisk_mobile_2tdpr.R
import com.example.byterisk_mobile_2tdpr.activities.*
import com.google.android.material.bottomnavigation.BottomNavigationView

object MenuNavigation {

    fun setupBottomNavigation(context: Context, bottomNavigationView: BottomNavigationView) {
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(context, HomeByteriskActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    context.startActivity(intent)
                    true
                }
                R.id.nav_employees -> {
                    val intent = Intent(context, EmployeesActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    context.startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
