package com.example.simpledateproject.database

import android.content.Context
import androidx.lifecycle.LiveData

class NotesRepository(context: Context) {

    var dbms : NotesDao? = NoteDatabase.getDatabase(context).noteDao()

    fun insertData(notesEntity: NotesEntity) {
         dbms!!.insertData(notesEntity)
    }

    fun updateData(notesEntity: NotesEntity){
        dbms?.updateData(notesEntity)
    }

    fun getDataOfDate(selectedDate : String): NotesEntity{
        return dbms?.getDataOfDate(selectedDate)!!
    }

    fun checkData(selectedDate : String) : Boolean{
        return dbms?.hasItem(selectedDate) == true
    }
}