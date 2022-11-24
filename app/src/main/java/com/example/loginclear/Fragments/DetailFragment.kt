package com.example.loginclear.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.loginclear.Ciclo
import com.example.loginclear.R

class DetailFragment(ciclo: Ciclo): Fragment() {
    var ciclo = ciclo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        val title: TextView = view.findViewById(R.id.titleCicle)
        title.text = ciclo.title
        val description: TextView = view.findViewById(R.id.descriptionCicle)
        description.text = ciclo.fullName
        return view
    }
}