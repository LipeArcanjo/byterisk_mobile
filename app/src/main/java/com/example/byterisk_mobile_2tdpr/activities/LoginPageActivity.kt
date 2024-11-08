package com.example.byterisk_mobile_2tdpr

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.byterisk_mobile_2tdpr.activities.HomeByteriskActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginPageActivity : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginButton: Button
    private lateinit var messageText: TextView

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        // Inicializando Firebase Auth
        auth = FirebaseAuth.getInstance()

        emailInput = findViewById(R.id.editTextEmail)
        passwordInput = findViewById(R.id.editTextPassword)
        loginButton = findViewById(R.id.buttonLogin)
        messageText = findViewById(R.id.messageTextView)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            performLogin(email, password)
        }
    }

    private fun performLogin(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            messageText.text = "Por favor, preencha os dois campos."
            return
        }

        // Firebase Authentication para login de usuários
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login bem-sucedido, redirecionar para a HomePageActivity
                    val user: FirebaseUser? = auth.currentUser
                    messageText.text = "Login realizado com sucesso"
                    Log.d("LoginPageActivity", "signInWithEmail:success")

                    val intent = Intent(this@LoginPageActivity, HomeByteriskActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Se o login falhar, mostrar uma mensagem ao usuário
                    Log.w("LoginPageActivity", "signInWithEmail:failure", task.exception)
                    messageText.text = "Erro: ${task.exception?.localizedMessage}"
                }
            }
    }
}
