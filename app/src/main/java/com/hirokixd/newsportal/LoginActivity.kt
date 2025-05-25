package com.hirokixd.newsportal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val register: TextView = findViewById(R.id.register)
        val loginButton: Button = findViewById(R.id.login_button)
        val loginEmail: EditText = findViewById(R.id.login_email)
        val loginPassword: EditText = findViewById(R.id.login_password)

        loginButton.setOnClickListener {
            val email = loginEmail.text.toString()
            val password = loginPassword.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (password.isEmpty()) {
                Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
                Log.d("LoginActivity", "User berhasil login ")

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        register.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
    }
}