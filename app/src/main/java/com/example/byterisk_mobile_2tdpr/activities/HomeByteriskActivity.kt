package com.example.byterisk_mobile_2tdpr.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.byterisk_mobile_2tdpr.R
import com.example.byterisk_mobile_2tdpr.utils.MenuNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeByteriskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        // Configurar a navegação no menu inferior e marcar o ícone correto
        bottomNavigationView.selectedItemId = R.id.nav_home
        MenuNavigation.setupBottomNavigation(this, bottomNavigationView)
    }

}
