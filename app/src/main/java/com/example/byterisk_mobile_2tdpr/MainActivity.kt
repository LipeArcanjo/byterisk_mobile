package com.example.byterisk_mobile_2tdpr

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // Declaração das variáveis
    lateinit var emailInput: EditText
    lateinit var passwordInput: EditText
    lateinit var loginButton: Button
    lateinit var messageText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Inicializando as variáveis com os elementos da interface
        emailInput = findViewById(R.id.editTextEmail)
        passwordInput = findViewById(R.id.editTextPassword)
        loginButton = findViewById(R.id.buttonLogin)
        messageText = findViewById(R.id.messageTextView)
        // Adiciona um listener ao botão de login
        loginButton.setOnClickListener {
            validateCredentials(it)
        }
    }
    // Função de validação de credenciais
    private fun validateCredentials(view: View) {
        // Obtém o texto dos EditTexts
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()
        // Valida se os campos não estão vazios
        if (email.isEmpty() || password.isEmpty()) {
            messageText.text = "Por favor, preencha os dois campos."
        } else {
            // Verifica as credenciais
            if (email == "byterisk@odontoprev.com" && password == "ByteRisk123") {
                messageText.text = "Credenciais aceitas, redirecionando..."
                // Aqui você pode implementar a lógica para redirecionar o usuário
            } else {
                messageText.text = "Credenciais erradas, por gentileza inclua novamente."
                // Limpar os campos
                emailInput.text.clear()
                passwordInput.text.clear()
            }
        }
    }
}