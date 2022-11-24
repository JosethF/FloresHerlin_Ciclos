package com.example.loginclear.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginclear.Ciclo
import com.example.loginclear.DB.CicloDBHelper
import com.example.loginclear.R
import com.example.loginclear.Recycler.RecyclerViewAdapter

class ListFragment(dbHelper: CicloDBHelper) : Fragment() {
    var dbHelper = dbHelper;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)

        var llistat: MutableList<Ciclo> = dbHelper.getAllData();
        var mRecyclerView: RecyclerView = view.findViewById(R.id.recyclerList);
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        val mAdapter : RecyclerViewAdapter = RecyclerViewAdapter(llistat, context, dbHelper);
        mRecyclerView.adapter = mAdapter
        mRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        return view
    }
}