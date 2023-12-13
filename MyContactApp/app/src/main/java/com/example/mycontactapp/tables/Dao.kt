package com.example.mycontactapp.tables

import androidx.annotation.RequiresPermission.Read
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface Dao {
    // crud operation , we need to create fun which helps to do crud operation bcoz dao get data from database and give to room

    @Query("SELECT * FROM contact_table ")
    fun readData():List<Contact>

    @Insert(entity=Contact::class, onConflict = OnConflictStrategy.IGNORE )
    fun insertData(contact: Contact):

    @Update
    fun updateData(contact: Contact)

    @Delete
    fun DeleteData(contact: Contact)


}