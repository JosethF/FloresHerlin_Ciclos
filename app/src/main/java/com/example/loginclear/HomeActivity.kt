package com.example.loginclear

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.loginclear.DB.CicloDBHelper
import com.example.loginclear.Fragments.FormFragment
import com.example.loginclear.Fragments.HomeFragment
import com.example.loginclear.Fragments.ListFragment
import com.example.loginclear.Fragments.SettingsFragment
import com.example.loginclear.Toolbar.HomeToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity: AppCompatActivity() {

    companion object{
        lateinit var dbHelper: CicloDBHelper;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        HomeToolbar().show(this)
        val bottomNav: BottomNavigationView = findViewById(R.id.main_menu)

        dbHelper = CicloDBHelper(this);

        //CHANGE THE FRAGMENT CLICKED
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return super.onCreateOptionsMenu(menu)
    }

    //THE TOOLBAR IS GENERATED HERE WITH THE OPTIONS TO CLICK WITH THEIR RESPECTIVE FUNCTIONS
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_fav->{
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            }
            R.id.nav_android->{
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            }
            R.id.optionLlogout->{
                //THE LOGOUT IS IN CHARGE OF DELETE THE LOGIN SHAREDEPREFERENCE AND RETURN TO THE MAIN ACTIVITY
                val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                var editor = sharedPreference.edit()
                editor.clear().commit();
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.optionSettings->{
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SettingsFragment()).commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadFragment(formFragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,formFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    //DATABASE DESTRUCTION
    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }
}