package com.example.todosapp.data.datasource

import com.example.todosapp.data.entity.Todos
import com.example.todosapp.room.TodosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodosDataSource(var tdao:TodosDao) {
    suspend fun loadTodos() : List<Todos> =
        withContext(Dispatchers.IO){
            return@withContext tdao.loadTodos()
        }

    suspend fun search(searchingWord:String) : List<Todos> =
        withContext(Dispatchers.IO){
            return@withContext tdao.search(searchingWord)
        }

    suspend fun register(name:String) {
        val newTodo = Todos(0,name)
        tdao.register(newTodo)
    }

    suspend fun update(id:Int,name:String) {
        val updatedTodo = Todos(id,name)
        tdao.update(updatedTodo)
    }

    suspend fun delete(id:Int) {
        val deletedTodo = Todos(id,"")
        tdao.delete(deletedTodo)
    }
}