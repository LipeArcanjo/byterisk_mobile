package com.example.byterisk_mobile_2tdpr.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.byterisk_mobile_2tdpr.*

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Inicializando o botão
        val buttonStart: Button = findViewById(R.id.buttonStart)

        // Configurando clique do botão para redirecionar à tela de login
        buttonStart.setOnClickListener {
            val intent = Intent(this, LoginPageActivity::class.java)
            startActivity(intent)
           }
    }
}