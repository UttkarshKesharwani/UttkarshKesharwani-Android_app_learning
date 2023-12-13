package com.example.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import com.example.optionmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.popupbtn.setOnClickListener {
            showPopupMenu(it)
        }

        registerForContextMenu(binding.contextbtn)

        binding.contextbtn.setOnClickListener {
            openContextMenu(binding.contextbtn)
        }




    }


    //making contextual menu
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.contextual_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.context1 -> {
                Toast.makeText(this@MainActivity, "item context 1 selected ", Toast.LENGTH_SHORT)
                    .show()

            }

            R.id.context2 -> {
                Toast.makeText(this@MainActivity, "item context 2 selected ", Toast.LENGTH_SHORT)
                    .show()

            }

            R.id.context3 -> {
                Toast.makeText(this@MainActivity, "item context 3 selected ", Toast.LENGTH_SHORT)
                    .show()

            }

            R.id.context4 -> {
                Toast.makeText(this@MainActivity, "item context 3 selected ", Toast.LENGTH_SHORT)
                    .show()

            }
        }
        return super.onContextItemSelected(item)
    }





    //to create a popup menu
    private fun showPopupMenu(it: View?) {
        val popupMenu=PopupMenu(this,it)
        popupMenu.inflate(R.menu.popup_menu)
        popupMenu.show()

        popupMenu.setOnMenuItemClickListener { item ->
            when(item.itemId){
                R.id.item1 -> {
                    Toast.makeText(this@MainActivity, "item 1 selected ", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item2 ->{
                    Toast.makeText(this@MainActivity, "item 2 selected ", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item3 ->{
                    Toast.makeText(this@MainActivity, "item 3 selected ", Toast.LENGTH_SHORT).show()
                     true
                }
                else -> false
        }



        }

    }

    // creating option menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.profile->{
                Toast.makeText(this, "profile selected", Toast.LENGTH_SHORT).show()
            }
            R.id.feedback->{
                Toast.makeText(this, "feedback selected", Toast.LENGTH_SHORT).show()
            }
            R.id.search->{
                Toast.makeText(this, "search selected", Toast.LENGTH_SHORT).show()
            }
            R.id.setting->{
                Toast.makeText(this, "setting selected", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }



























}