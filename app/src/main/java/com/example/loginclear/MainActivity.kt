package com.example.loginclear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SystemClock.sleep(200);
        setTheme(R.style.Theme_LoginClear);
        var btnSignIn: Button = findViewById(R.id.btnSignIn);
        var txtUsername: EditText = findViewById(R.id.txtUsername);
        var txtPassword:EditText = findViewById(R.id.txtPassword);
        var txtLabel:TextView = findViewById(R.id.loginResult);

        //CHECK THE LOGIN APP
        btnSignIn.setOnClickListener(){
            if(txtUsername.text.toString() == "admin" && txtPassword.text.toString() == "admin"){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }else{ txtLabel.text = "Datos incorrectos" }
        }
    }
}