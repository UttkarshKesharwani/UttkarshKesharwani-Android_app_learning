package com.example.mycontactapp.tables

import android.content.Context
import androidx.room.Room

object CreateDb {

    var db:MainDb?=null
    fun createDb(context: Context):MainDb{
        if(db==null){
            db=Room.databaseBuilder(context,MainDb::class.java, "My_DataBase").build()
        }
        return db!!
    }
}