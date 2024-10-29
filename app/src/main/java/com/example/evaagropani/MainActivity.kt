package com.example.evaagropani

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
        lo que hace findViewById< >(R.id.ID) es aplicar un selector, que va a buscar en donde lo referencies una Id especifica,
        pero solo la buscara en los tipos que indiques, el tipo que indiques va entre los < >
        por eso, tu mainactivity estaba intentando buscar la id tvUsuario, en un TextView
        pero tu estabas ingresando los datos en un edittext de tipo:<com.google.android.material.textfield.TextInputEditText>
         */

        val usuario = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.tvUsuario)
        val password = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.tvPassword)
        val btnLogin = findViewById<Button>(R.id.btniniciarsesion)

        btnLogin.setOnClickListener {
            try {
                val userInput = usuario.text.toString()
                val passInput = password.text.toString()

                // Validar si los campos están vacíos
                if (userInput.isEmpty() || passInput.isEmpty()) {
                    Toast.makeText(this, "Por favor, rellena ambos campos", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Simular autenticación con credenciales predeterminadas
                if (userInput == "admin" && passInput == "1234") {
                    val intent = Intent(this, Menu::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }

            } catch (e: Exception) {
                // Capturar cualquier excepción inesperada
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }
    }
}
