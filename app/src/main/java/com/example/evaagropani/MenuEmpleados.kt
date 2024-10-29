package com.example.evaagropani

import android.content.Intent // Asegúrate de importar Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.Toast

class MenuEmpleados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Llamar a enableEdgeToEdge antes de super.onCreate
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_empleados)

        // Configurar el OnClickListener para el botón
        val mainLayout = findViewById<LinearLayout>(R.id.main) // Asegúrate de que `main` es el ID correcto

        // Manejo de excepciones al aplicar los insets de la ventana
        try {
            ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            // Inicializa el botón usando findViewById
            val btnRegistrarEmpleado = findViewById<Button>(R.id.btnregistrarempleado)

            btnRegistrarEmpleado.setOnClickListener {
                // Crear la intención para cambiar a la actividad de registro de empleados
                val intent = Intent(this, RegistroEmpleados::class.java)
                startActivity(intent) // Iniciar la nueva actividad
            }
        } catch (e: Exception) {
            // Manejar la excepción
            e.printStackTrace() // Imprimir el stack trace en caso de error
            Toast.makeText(this, "Ocurrió un error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}

