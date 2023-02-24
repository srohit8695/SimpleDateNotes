package com.example.simpledateproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {

    @Insert
    fun insertData(notesEntity: NotesEntity)

    @Update
    fun updateData(notesEntity: NotesEntity)

    @Query("Select * from notesTable WHERE date = :selectedDate")
    fun getDataOfDate(selectedDate : String): NotesEntity

    @Query("SELECT EXISTS (SELECT 1 FROM notesTable WHERE date = :selectedDate)")
    fun hasItem(selectedDate : String): Boolean

}