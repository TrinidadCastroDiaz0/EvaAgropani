package com.example.evaagropani

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView

class AsistenciaAdapter(context: Context, private val empleados: List<RegistroEmpleados.Empleado>) :
    ArrayAdapter<RegistroEmpleados.Empleado>(context, 0, empleados) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_asistencia, parent, false)
        val nombreEmpleado = view.findViewById<TextView>(R.id.textViewEmpleadoNombre)
        val checkBoxAsistencia = view.findViewById<CheckBox>(R.id.checkBoxAsistencia)

        // Obtener el empleado actual y asignar el nombre al TextView
        val empleado = empleados[position]
        nombreEmpleado.text = empleado.nombre // Asegúrate de que 'nombre' sea un campo de 'Empleado'

        // Configurar el listener para el checkbox de asistencia
        checkBoxAsistencia.setOnCheckedChangeListener { _, isChecked ->
            empleado.asistencia = isChecked
        }

        return view
    }
}