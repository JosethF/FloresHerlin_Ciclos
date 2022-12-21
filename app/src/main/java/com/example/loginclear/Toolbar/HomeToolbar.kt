package com.example.loginclear.Toolbar

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.loginclear.R

class HomeToolbar {
    fun show(activities : AppCompatActivity){
        activities.setSupportActionBar(activities.findViewById(R.id.homeToolbar))
        //activities.supportActionBar?.title = "ChangeLanguage"
    }
}