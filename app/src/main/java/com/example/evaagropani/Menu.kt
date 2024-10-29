package com.example.evaagropani

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        try {
            // Aplicar el listener para manejar los márgenes de las barras del sistema
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            // Configurar el botón para redirigir a la actividad MenuCosecha
            val btnCosecha: Button = findViewById(R.id.btncosecha)
            btnCosecha.setOnClickListener {
                val intent = Intent(this, MenuCosecha::class.java)
                startActivity(intent)
            }

            // Configurar el botón para redirigir a la actividad MenuEmpleados
            val btnEmpleados: Button = findViewById(R.id.btnempleados)
            btnEmpleados.setOnClickListener {
                val intent = Intent(this, MenuEmpleados::class.java)
                startActivity(intent)
            }

            // Configurar el botón para redirigir a la actividad MenuAsistencia
            val btnAsistencia: Button = findViewById(R.id.btnasistencia)
            btnAsistencia.setOnClickListener {
                val intent = Intent(this, Asistencia::class.java)
                startActivity(intent)
            }

        } catch (e: Exception) {
            // Manejar la excepción
            e.printStackTrace() // Imprimir el stack trace en caso de error
            Toast.makeText(this, "Ocurrió un error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}