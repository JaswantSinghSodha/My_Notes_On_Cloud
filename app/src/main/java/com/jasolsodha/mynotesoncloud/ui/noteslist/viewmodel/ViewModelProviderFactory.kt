package com.js.jskotlindemo.coromind.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jasolsodha.mynotesoncloud.ui.noteslist.NotesListViewModel

class ViewModelProviderFactory () : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(NotesListViewModel::class.java)){
            return NotesListViewModel() as T
        }

        throw IllegalArgumentException("Unknown class name")
    }
}