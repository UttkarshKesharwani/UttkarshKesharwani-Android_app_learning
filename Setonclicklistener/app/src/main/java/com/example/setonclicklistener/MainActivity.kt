package com.example.setonclicklistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn =findViewById<Button>(R.id.login_button)
        btn.setOnClickListener {
            Toast.makeText(this, "hello", Toast.LENGTH_LONG).show()
        }
        val text1=findViewById<EditText>(R.id.editTextText2)
        text1.setOnClickListener {
            Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show()
        }




    }
}