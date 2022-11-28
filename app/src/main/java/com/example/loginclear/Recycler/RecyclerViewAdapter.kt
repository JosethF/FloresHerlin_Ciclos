package com.example.loginclear.Recycler


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.loginclear.Ciclo
import com.example.loginclear.DB.CicloDBHelper
import com.example.loginclear.Fragments.DetailFragment
import com.example.loginclear.Fragments.FormFragment
import com.example.loginclear.Fragments.ListFragment
import com.example.loginclear.HomeActivity
import com.example.loginclear.R

class RecyclerViewAdapter(llistat: MutableList<Ciclo>, context: Context?, db:CicloDBHelper): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var llistat: MutableList<Ciclo> = llistat;
    var context: Context? = context;
    var dbHelper = db;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }

    @SuppressLint("RecyclerView")
    override fun onBindViewHolder(holder: ViewHolder,  position: Int) {
        holder.txtTitle.text = llistat[position].title;
        holder.txtFullName.text = llistat[position].fullName;

        holder.itemView.setOnClickListener(
            object:View.OnClickListener{
                override fun onClick(v: View?) {
                    val activity = v!!.context as AppCompatActivity
                    val llistat = dbHelper.getAllData()
                    activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, DetailFragment(llistat[position])).addToBackStack(null).commit();
                }
            }
        )

        holder.btnRemoveItem.setOnClickListener(){
            var lista = dbHelper.getAllData()
            var item = lista[position].id
            dbHelper.deleteSelectData(item)
            Toast.makeText(context, "¡Ciclo Borrado!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return llistat.size;
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtTitle: TextView = view.findViewById(R.id.txtTitleList);
        val txtFullName: TextView = view.findViewById(R.id.txtFullNameList);
        val btnRemoveItem: Button = view.findViewById(R.id.btnRemoveItem);
    }
}