package com.example.todosapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todosapp.data.repo.TodosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoRecordViewModel @Inject constructor(var trepo:TodosRepository) : ViewModel() {
    fun register(name:String) {
        CoroutineScope(Dispatchers.Main).launch {
            trepo.register(name)
        }
    }
}