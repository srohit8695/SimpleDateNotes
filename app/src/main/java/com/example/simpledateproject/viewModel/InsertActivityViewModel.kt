package com.example.simpledateproject.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.simpledateproject.database.NotesEntity
import com.example.simpledateproject.database.NotesRepository
import kotlinx.coroutines.launch

class InsertActivityViewModel(application: Application) : AndroidViewModel(application)  {

    private val repository : NotesRepository = NotesRepository(application)
    val notes = MutableLiveData<String>()

    fun insertData(date : String, enterData : String) {
        val data = NotesEntity(date, enterData)
        repository.insertData(data)
    }

    fun checkData(selectedDate : String) : Boolean{
        return repository.checkData(selectedDate)
    }

    fun getDataOfDate(selectedDate : String) {
        val data = repository.getDataOfDate(selectedDate)
        notes.value = data.notes
    }

}