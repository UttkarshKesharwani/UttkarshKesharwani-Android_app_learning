package com.example.mycontactapp.tables

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = arrayOf(Contact::class),version=1, exportSchema = false)
abstract class MainDb : RoomDatabase() {

    abstract fun dao():Dao
}