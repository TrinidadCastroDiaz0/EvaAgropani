package com.example.evaagropani

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast

class EmpleadoAdapter(context: Context, empleados: List<RegistroEmpleados.Empleado>) :
    ArrayAdapter<RegistroEmpleados.Empleado>(context, 0, empleados) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Obtiene el empleado actual
        val empleado = getItem(position)

        // Infla la vista
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.activity_empleado_adapter, parent, false)

        try {
            // Configura la vista con los datos del empleado
            val nombreE = view.findViewById<TextView>(R.id.nombreE)
            val correoE = view.findViewById<TextView>(R.id.correoE)
            val direccionE = view.findViewById<TextView>(R.id.direccionE)
            val rutE= view.findViewById<TextView>(R.id.rutE)
            val telefonoE = view.findViewById<TextView>(R.id.telefonoE)
            val emergenciaE = view.findViewById<TextView>(R.id.emergenciaE)

            // Asigna los valores a los TextViews
            empleado?.let {
                nombreE.text = it.nombre
                correoE.text = it.correo
                direccionE.text = it.direccion
                rutE.text = it.rut
                telefonoE.text = it.telefono
                emergenciaE.text = it.emergencia
            }
        } catch (e: Exception) {
            // Manejar la excepción
            e.printStackTrace() // Imprimir el stack trace en caso de error
            // Podrías mostrar un mensaje en un Toast o en un log
            Toast.makeText(context, "Error al cargar los datos del empleado: ${e.message}", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
