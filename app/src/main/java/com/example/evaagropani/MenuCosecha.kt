package com.example.evaagropani

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button


class   MenuCosecha : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_cosecha)

        // Obtener el botón "Registrar cosecha" del layout
        val btnRegistrarCosecha = findViewById<Button>(R.id.btnRegistarCosecha)

        // Configurar el listener del botón
        btnRegistrarCosecha.setOnClickListener {
            // Iniciar la actividad de registrar cosecha
            startActivity(Intent(this, RegistrarCosecha::class.java))
        }
    }
}