package com.example.simpledateproject.database

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "notesTable")
data class NotesEntity(
    val date : String,
    val notes: String,
    @PrimaryKey(autoGenerate = true) val id: Int?= null
)
