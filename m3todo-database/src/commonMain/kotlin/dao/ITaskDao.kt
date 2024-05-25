package com.github.mukiva.m3todo.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.github.mukiva.m3todo.database.models.TaskDbo
import kotlinx.coroutines.flow.Flow

@Dao
interface ITaskDao {
    @Upsert
    suspend fun upsert(task: TaskDbo)
    @Delete
    suspend fun delete(task: TaskDbo)
    @Query("SELECT * FROM taskdbo")
    fun getAllTasks(): Flow<List<TaskDbo>>

}