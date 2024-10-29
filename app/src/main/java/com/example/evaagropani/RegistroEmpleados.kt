package com.example.evaagropani

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistroEmpleados : AppCompatActivity() {

    // Clase de datos para representar a un empleado
    data class Empleado(
        var nombre: String,
        var correo: String,
        var direccion: String,
        var rut: String,
        var telefono: String,
        var emergencia: String,
        var asistencia: Boolean = false // Nuevo campo para el estado de asistencia
    ) : java.io.Serializable // Implementa Serializable para pasar datos entre actividades

    // Definición de variables para los campos de entrada
    private lateinit var nombre: EditText
    private lateinit var correo: EditText
    private lateinit var direccion: EditText
    private lateinit var rut: EditText
    private lateinit var telefono: EditText
    private lateinit var emergencia: EditText
    private lateinit var registrarButton: Button
    private lateinit var verEmpleadosButton: Button

    // Lista para almacenar los empleados
    private val empleadosList = mutableListOf<Empleado>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro_empleados)

        // Inicialización de vistas
        nombre = findViewById(R.id.nombreempleado)
        correo= findViewById(R.id.correoempleado)
        direccion = findViewById(R.id.direccionempleado)
        rut = findViewById(R.id.rutempleado)
        telefono = findViewById(R.id.numempleado)
        emergencia = findViewById(R.id.numempleadoemergencia)
        registrarButton = findViewById(R.id.btnregistrarempleado2)
        verEmpleadosButton = findViewById(R.id.btnVerEmpleados)

        // Configurar los botones
        registrarButton.setOnClickListener { registrarEmpleado() }
        verEmpleadosButton.setOnClickListener { verEmpleados() }

        // Configuración de padding para el sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun registrarEmpleado() {
        // Obtener los datos de los campos de entrada
        val nombre = nombre.text.toString().trim()
        val correo = correo.text.toString().trim()
        val direccion = direccion.text.toString().trim()
        val rut = rut.text.toString().trim()
        val telefono = telefono.text.toString().trim()
        val emergencia = emergencia.text.toString().trim()

        // Verificar que todos los campos estén completos
        if (nombre.isNotEmpty() && correo.isNotEmpty() && direccion.isNotEmpty() && rut.isNotEmpty() && telefono.isNotEmpty() && emergencia.isNotEmpty()) {
            // Crear un nuevo empleado y agregarlo a la lista
            val empleado = Empleado(nombre, correo, direccion, rut, telefono, emergencia)
            empleadosList.add(empleado)

            // Mostrar un mensaje de éxito
            Toast.makeText(this, "Empleado registrado exitosamente", Toast.LENGTH_SHORT).show()

            // Limpiar campos
            limpiarCampos()
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun limpiarCampos() {
        // Limpiar todos los campos de entrada
        nombre.text.clear()
        correo.text.clear()
        direccion.text.clear()
        rut.text.clear()
        telefono.text.clear()
        emergencia.text.clear()
    }

    private fun verEmpleados() {
        // Redirigir a VerEmpleados y pasar la lista de empleados
        val intent = Intent(this, VerEmpleados::class.java)
        intent.putExtra("empleados", ArrayList(empleadosList))
        startActivity(intent)
    }
}