package com.example.byterisk_mobile_2tdpr.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.byterisk_mobile_2tdpr.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.FirebaseApp


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
            finish() // Finaliza a splash screen para que o usuário não possa voltar a ela.
           }

        // Inicializar o Firebase App
        FirebaseApp.initializeApp(this)

        // Inicializar o Realtime Database
        val database = Firebase.database("https://byterisk-mobile-default-rtdb.firebaseio.com/")
    }
}