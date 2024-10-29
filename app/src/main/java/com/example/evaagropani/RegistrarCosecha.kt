package com.example.evaagropani

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class RegistrarCosecha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrar_cosecha)

        // Inicializar los campos de texto y el botón
        val tipoCosechaEditText = findViewById<EditText>(R.id.etTipoCosecha)
        val cantidadCosechadaEditText = findViewById<EditText>(R.id.etCantidadCosechada)
        val btnGuardarCosecha = findViewById<MaterialButton>(R.id.btnGuardarCosecha)

        // Configurar el botón para guardar la cosecha
        btnGuardarCosecha.setOnClickListener {
            try {
                val tipoCosecha = tipoCosechaEditText.text.toString()
                val cantidadCosechada = cantidadCosechadaEditText.text.toString().toDoubleOrNull()

                // Verificar si los campos están completos
                if (tipoCosecha.isNotEmpty() && cantidadCosechada != null) {
                    // Aquí puedes agregar el código para guardar la cosecha

                    Toast.makeText(this, "Cosecha registrada exitosamente", Toast.LENGTH_SHORT).show()
                } else {
                    throw IllegalArgumentException("Datos incompletos")
                }
            } catch (e: Exception) {
                // Mostrar el mensaje de "Cosecha no registrada" si hay un error
                Toast.makeText(this, "Cosecha no registrada", Toast.LENGTH_SHORT).show()
            }
        }

        // Aplicar el padding de las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainRegistar)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}