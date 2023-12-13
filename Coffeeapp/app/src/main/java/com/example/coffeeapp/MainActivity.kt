package com.example.coffeeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.coffeeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.shopbtn.setOnClickListener {

            startActivity(Intent(this,Login_page::class.java))
        }


//        var btn: Button = findViewById<Button>(R.id.shopbtn)
//        btn.setOnClickListener {
//            var intent = Intent(this,Login_page::class.java)
//            startActivity(intent)
//        }
        

    }
}