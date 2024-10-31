package com.example.todosapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todosapp.data.entity.Todos
import com.example.todosapp.data.repo.TodosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(var trepo:TodosRepository) : ViewModel() {
    var todosList = MutableLiveData<List<Todos>>()

    init {
        loadTodos()
    }

    fun delete(id:Int) {
        CoroutineScope(Dispatchers.Main).launch {
            trepo.delete(id)
            loadTodos()
        }
    }

    fun loadTodos() {
        CoroutineScope(Dispatchers.Main).launch {
            todosList.value = trepo.loadTodos()
        }
    }

    fun search(searchingWord:String){
        CoroutineScope(Dispatchers.Main).launch {
            todosList.value = trepo.search(searchingWord)
        }
    }
}