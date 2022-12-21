package com.example.loginclear

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //recoger el idioma del SH
        //LLamar a la función


        setContentView(R.layout.activity_main)

        SystemClock.sleep(200);
        setTheme(R.style.Theme_LoginClear);
        var btnSignIn: Button = findViewById(R.id.btnSignIn);
        var txtUsername: EditText = findViewById(R.id.txtUsername);
        var txtPassword:EditText = findViewById(R.id.txtPassword);
        var txtLabel:TextView = findViewById(R.id.loginResult);
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        if(sharedPreference.getBoolean("login",false)){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        //CHECK THE LOGIN APP
        btnSignIn.setOnClickListener(){
            if(txtUsername.text.toString() == "admin" && txtPassword.text.toString() == "admin"){
                sharedPreference.edit().putBoolean("login",true).commit()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }else{ txtLabel.visibility = View.VISIBLE }
        }
    }
}