package com.example.loginclear

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.loginclear.DB.CicloDBHelper
import com.example.loginclear.Fragments.FormFragment
import com.example.loginclear.Fragments.HomeFragment
import com.example.loginclear.Fragments.ListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity: AppCompatActivity() {

    companion object{
        lateinit var dbHelper: CicloDBHelper;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bottomNav: BottomNavigationView = findViewById(R.id.main_menu)

        dbHelper = CicloDBHelper(this);

        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_form -> {
                    loadFragment(FormFragment(dbHelper))
                    true
                }
                R.id.nav_list -> {
                    loadFragment(ListFragment(dbHelper))
                    true
                }
                else -> {false}
            }
        }
    }

    private fun loadFragment(formFragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,formFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }

}