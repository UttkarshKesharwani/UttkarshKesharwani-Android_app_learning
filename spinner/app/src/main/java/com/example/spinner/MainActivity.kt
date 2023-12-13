package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding= ActivityMainBinding.inflate(layoutInflater)

        binding.




    }
}