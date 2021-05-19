package com.example.lok.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.lok.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.passsword)
        val button = findViewById<Button>(R.id.loginBtn)

        button.setOnClickListener {
            // LoginFunktion an diese Stelle einpflegen
            // Folgender Codeabschnitt lädt die Anwendung
            Intent(this, MainActivity::class.java).also {
                startActivity(it, null)
            }
        }
    }
}