package com.example.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.explicitintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var name:String
        var number:String
        var age:Byte


        binding.button.setOnClickListener(){

            name=binding.name.text.toString()
            number=binding.phone.text.toString()
            age=binding.age.text.toString().toByte()
            var intentfornext=Intent(this , MainActivity2::class.java)

            intentfornext.putExtra("NAME_KEY",name)
            intentfornext.putExtra("PASS_KEY",number)
            intentfornext.putExtra("AGE_KEY",age)


            startActivity(intentfornext)



        }

    }
}