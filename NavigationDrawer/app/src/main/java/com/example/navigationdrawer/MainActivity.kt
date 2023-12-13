package com.example.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {

        ActivityMainBinding.inflate(layoutInflater)
    }
    var actionBarDrawerToggle:ActionBarDrawerToggle?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


//        actionBarDrawerToggle=ActionBarDrawerToggle(this,binding.drawerlayout,R.string.open,R.string.close)
//        binding.drawerlayout.addDrawerListener(actionBarDrawerToggle!!)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        binding.toolBar.setNavigationOnClickListener(){
//            if(binding.drawerlayout.isDrawerVisible(GravityCompat.START)){
//                binding.drawerlayout.closeDrawer(GravityCompat.START)
//            }else{
//                binding.drawerlayout.openDrawer(GravityCompat.START)
//            }
//            }


        // We can also create navigation drawer using this
        actionBarDrawerToggle= ActionBarDrawerToggle(this,binding.drawerlayout,binding.toolBar,R.string.open,R.string.close)
        binding.drawerlayout.addDrawerListener(actionBarDrawerToggle!!)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)


        // To enable click on clicking the items of navigation drawers

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.new_group ->{ Toast.makeText(this, "this is new_group", Toast.LENGTH_SHORT).show()
                true
                }
                R.id.calls->{
                    Toast.makeText(this, "this is call ", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.contact -> {
                    Toast.makeText(this, "this is contact", Toast.LENGTH_SHORT).show()
                    true

                }
                R.id.message -> {
                    Toast.makeText(this, "this is message", Toast.LENGTH_SHORT).show()
                    true

                }

                else -> {false}
            }
        }


        // to create bottom navigation
//        val navController:NavController=findNavController(R.id.fragment_container_view)
//        binding.bottomNavigationView.setupWithNavController(navController)
//


    }


}
