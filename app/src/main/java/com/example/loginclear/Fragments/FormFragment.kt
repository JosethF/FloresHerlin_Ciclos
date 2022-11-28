package com.example.loginclear.Fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.loginclear.Ciclo
import com.example.loginclear.DB.CicloDBHelper
import com.example.loginclear.R

class FormFragment(dbH: CicloDBHelper) : Fragment() {
    var dbHelper = dbH;

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_form, container, false)

        val btnForm : Button = view.findViewById(R.id.buttonForm)
        val btnList : Button = view.findViewById(R.id.buttonList)
        val btnDelete : Button = view.findViewById(R.id.buttonDelete)

        btnForm.setOnClickListener(){
            val titulo : EditText = view.findViewById(R.id.txtTitle)
            val inputTitulo = titulo.text.toString()
            val fullName : EditText = view.findViewById(R.id.txtFullName)
            val inputFullName = fullName.text.toString()
            var id = dbHelper.getAllData().size
            dbHelper.insertCiclo(Ciclo(id, inputTitulo.toString(), inputFullName.toString()))
            Toast.makeText(context, "¡Ciclo Guardado!", Toast.LENGTH_SHORT).show()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container,FormFragment(dbHelper))?.addToBackStack(null)?.commit()
        }

        btnList.setOnClickListener() {
            dbHelper.logListData()
            Toast.makeText(context, "¡Listado en LOG!", Toast.LENGTH_SHORT).show()
        }

        btnDelete.setOnClickListener(){
            val builder = AlertDialog.Builder(context)
            builder.setMessage("¿Estás seguro que quieres borrar todos los ciclos? ¡Desgraciado!")
                .setPositiveButton("OK",
                    DialogInterface.OnClickListener { dialog, id ->
                        dbHelper.deleteAllData()
                        Toast.makeText(context, "¡Ciclos Borrados!", Toast.LENGTH_SHORT).show()
                    })
                .setNegativeButton("Cancel",
                    DialogInterface.OnClickListener { dialog, id ->
                        Toast.makeText(context, "¡Cuidado con ese dedo!", Toast.LENGTH_SHORT).show()
                    })
            // Create the AlertDialog object and return it
            builder.create().show()
        }
        return view
    }
}