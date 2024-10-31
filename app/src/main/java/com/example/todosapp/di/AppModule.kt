package com.example.todosapp.di

import android.content.Context
import androidx.room.Room
import com.example.todosapp.data.datasource.TodosDataSource
import com.example.todosapp.data.repo.TodosRepository
import com.example.todosapp.room.AppDatabase
import com.example.todosapp.room.TodosDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideTodosDataSource(tdao:TodosDao) : TodosDataSource {
        return TodosDataSource(tdao)
    }

    @Provides
    @Singleton
    fun provideTodosTodosRepository(tds:TodosDataSource) : TodosRepository {
        return TodosRepository(tds)
    }

    @Provides
    @Singleton
    fun provideTodosDao(@ApplicationContext context: Context) : TodosDao {
        val db = Room.databaseBuilder(context,AppDatabase::class.java,"todos.sqlite")
            .createFromAsset("todos.sqlite").build()
        return db.getTodosDao()
    }
}