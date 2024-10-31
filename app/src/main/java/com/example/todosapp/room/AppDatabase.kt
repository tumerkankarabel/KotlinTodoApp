package com.example.todosapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todosapp.data.entity.Todos

@Database(entities = [Todos::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getTodosDao() : TodosDao
}