package com.example.evaagropani


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActualizarEmpleado : AppCompatActivity() {

    private lateinit var nombreEditText: EditText
    private lateinit var correoEditText: EditText
    private lateinit var direccionEditText: EditText
    private lateinit var rutEditText: EditText
    private lateinit var telefonoEditText: EditText
    private lateinit var emergenciaEditText: EditText
    private lateinit var actualizarButton: Button

    private lateinit var empleado: RegistroEmpleados.Empleado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_empleado)

        // Inicialización de vistas
        nombreEditText = findViewById(R.id.nombreempleado)
        correoEditText = findViewById(R.id.correoempleado)
        direccionEditText = findViewById(R.id.direccionempleado)
        rutEditText = findViewById(R.id.rutempleado)
        telefonoEditText = findViewById(R.id.numempleado)
        emergenciaEditText = findViewById(R.id.numempleadoemergencia)
        actualizarButton = findViewById(R.id.btnActualizarEmpleado)

        // Obtener el empleado pasado a través del Intent
        empleado = intent.getSerializableExtra("empleado") as RegistroEmpleados.Empleado

        // Llenar los campos con los datos del empleado
        nombreEditText.setText(empleado.nombre)
        correoEditText.setText(empleado.correo)
        direccionEditText.setText(empleado.direccion)
        rutEditText.setText(empleado.rut)
        telefonoEditText.setText(empleado.telefono)
        emergenciaEditText.setText(empleado.emergencia)

        // Configurar el botón de actualización
        actualizarButton.setOnClickListener { actualizarEmpleado() }
    }

    private fun actualizarEmpleado() {
        // Obtener los datos de los campos de entrada
        empleado.nombre = nombreEditText.text.toString().trim()
        empleado.correo = correoEditText.text.toString().trim()
        empleado.direccion = direccionEditText.text.toString().trim()
        empleado.rut = rutEditText.text.toString().trim()
        empleado.telefono = telefonoEditText.text.toString().trim()
        empleado.emergencia = emergenciaEditText.text.toString().trim()

        // Mostrar un mensaje de éxito
        Toast.makeText(this, "Empleado actualizado exitosamente", Toast.LENGTH_SHORT).show()

        // Finalizar la actividad y volver a la anterior
        finish()
    }
}