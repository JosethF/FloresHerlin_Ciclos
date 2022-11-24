package com.example.loginclear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnSignIn: Button = findViewById(R.id.btnSignIn);
        var txtUsername: EditText = findViewById(R.id.txtUsername);
        var txtPassword:EditText = findViewById(R.id.txtPassword);
        var txtLabel:TextView = findViewById(R.id.loginResult);

        btnSignIn.setOnClickListener(){
            if(txtUsername.text.toString() == "" && txtPassword.text.toString() == ""){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }else{ txtLabel.text = "Datos incorrectos" }
        }
    }
}