package com.example.evaagropani

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VerEmpleados : AppCompatActivity() {

    private lateinit var listViewEmpleados: ListView
    private val empleadosList = mutableListOf<RegistroEmpleados.Empleado>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ver_empleados)

        try {
            listViewEmpleados = findViewById(R.id.listViewEmpleados)

            // Obtener la lista de empleados del intent
            val empleados = intent.getSerializableExtra("empleados") as? List<RegistroEmpleados.Empleado>
            empleados?.let {
                empleadosList.addAll(it)
            } ?: run {
                Toast.makeText(this, "No se encontraron empleados registrados", Toast.LENGTH_SHORT).show()
            }

            // Configurar el adaptador
            val adapter = EmpleadoAdapter(this, empleadosList)
            listViewEmpleados.adapter = adapter

            // Configuración de padding para el sistema
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        } catch (e: Exception) {
            // Manejar la excepción
            e.printStackTrace() // Imprimir el stack trace en caso de error
            Toast.makeText(this, "Ocurrió un error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}

