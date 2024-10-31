package com.example.todosapp.data.repo

import com.example.todosapp.data.datasource.TodosDataSource
import com.example.todosapp.data.entity.Todos

class TodosRepository(var tds:TodosDataSource) {
    suspend fun register(name:String) = tds.register(name)

    suspend fun update(id:Int,name:String) = tds.update(id,name)

    suspend fun delete(id:Int) = tds.delete(id)

    suspend fun loadTodos() : List<Todos> = tds.loadTodos()

    suspend fun search(searchingWord:String) : List<Todos> = tds.search(searchingWord)
}