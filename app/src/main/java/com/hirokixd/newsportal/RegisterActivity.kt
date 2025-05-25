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
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val registerButton: Button = findViewById(R.id.register_button)
        val loginTextButton : TextView = findViewById(R.id.logintext)
        val registerEmail : EditText = findViewById(R.id.register_email)
        val registerPassword : EditText = findViewById(R.id.register_password)
        val registerConfirmPassword : EditText = findViewById(R.id.register_confirm_password)

        registerButton.setOnClickListener {
            val email = registerEmail.text.toString()
            val password = registerPassword.text.toString()
            val confirm = registerConfirmPassword.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (password.isEmpty()) {
                Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (confirm.isEmpty()) {
                Toast.makeText(this, "Konfirmasi password anda", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
                Log.d("LoginActivity", "User berhasil registrasi ")

                val i = Intent(this, LoginActivity::class.java)
                startActivity(i)
            }
        }


        loginTextButton.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
    }
}