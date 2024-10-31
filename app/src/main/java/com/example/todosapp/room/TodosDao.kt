package com.example.todosapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todosapp.data.entity.Todos

@Dao
interface TodosDao {
    @Query("SELECT * FROM todos")
    suspend fun loadTodos() : List<Todos>

    @Insert
    suspend fun register(todo:Todos)

    @Update
    suspend fun update(todo:Todos)

    @Delete
    suspend fun delete(todo:Todos)

    @Query("SELECT * FROM todos WHERE name like '%' || :searchingWord || '%'")
    suspend fun search(searchingWord:String) : List<Todos>
}