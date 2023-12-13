package com.example.rv_view

import android.content.Intent
import android.icu.lang.UCharacter.VerticalOrientation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rv_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()  {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dataList = ArrayList<Model>()



        for(i in 1..10){
            dataList.add(Model(R.drawable.a,"Black coffee","ICED AMERICANO"))
            dataList.add(Model(R.drawable.b,"Winter special ","CAPPUCINO LATTE"))
            dataList.add(Model(R.drawable.c,"DECAFF","SILKY CAFE  LAIT "))
            dataList.add(Model(R.drawable.d,"CHOCO","Iced Chocolate"))
        }



        val adapter=Adapter(dataList)

        binding.rv.adapter=adapter
        binding.rv.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true)


    }
}