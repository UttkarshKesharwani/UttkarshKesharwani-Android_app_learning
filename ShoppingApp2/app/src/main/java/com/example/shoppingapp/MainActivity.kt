package com.example.shoppingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppingapp.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun GotoNext(view: View) {
        if(Firebase.auth==null){
            startActivity(Intent(this@MainActivity,SignupLoginActivity::class.java))
            finish()
        }else
        {
            startActivity(Intent(this@MainActivity,HomeActivity::class.java))
        }

    }
}