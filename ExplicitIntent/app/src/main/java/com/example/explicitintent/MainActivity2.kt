package com.example.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.explicitintent.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var name:String=intent.getStringExtra("NAME_KEY")!!
        var number:String=intent.getStringExtra("NUMBER_KEY")!!
        var age:Byte=intent.getByteExtra("AGE_KEY",-1).toByte().toString()

      binding.name.setText(name)
      binding.phone.setText(number)
      binding.age.text.(age)
    }
}