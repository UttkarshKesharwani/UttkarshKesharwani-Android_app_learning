package com.example.youtuberecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtuberecycleview.databinding.ActivityMainBinding
import drawable.AdapterRec
import drawable.Model

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var dataList=ArrayList<Model>()


        for(i in 1..2){
            dataList.add(Model((R.drawable.a),R.drawable.profile,"welcome to the neat roots"))
            dataList.add(Model((R.drawable.b),R.drawable.profile,"welcome to the neat roots"))
            dataList.add(Model((R.drawable.c),R.drawable.profile,"welcome to the neat roots"))
            dataList.add(Model((R.drawable.d),R.drawable.profile,"welcome to the neat roots"))

        }

        var adapter=AdapterRec(dataList)
        binding.recycle.adapter=adapter
        binding.recycle.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

    }



}