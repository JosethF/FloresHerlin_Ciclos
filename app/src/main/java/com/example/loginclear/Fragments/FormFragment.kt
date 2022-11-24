package com.example.loginclear.Fragments

import android.annotation.SuppressLint
import android.content.Context
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
import com.example.loginclear.HomeActivity
import com.example.loginclear.R
import com.google.android.material.snackbar.Snackbar

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
            dbHelper.insertCiclo(Ciclo(inputTitulo.toString(), inputFullName.toString()))
            /*
                val bundle = Bundle()
                bundle.putString("title",inputTitulo)
                bundle.putString("fullName",inputFullName)
                val listFragment = ListFragment()
                listFragment.arguments = bundle
            */
            //val listFragment = ListFragment(HomeActivity.dbHelper)
            //activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container,listFragment)?.addToBackStack(null)?.commit()
            Toast.makeText(context, "¡Ciclo Guardado!", Toast.LENGTH_SHORT).show()
        }

        btnList.setOnClickListener() {
            dbHelper.logListData()
        }

        btnDelete.setOnClickListener(){
            dbHelper.deleteAllData()
            val snack = Snackbar.make(view.findViewById(R.id.fragment_form),"Datos Borrados",Snackbar.LENGTH_LONG)
            snack.show()
        }

        return view
    }
}