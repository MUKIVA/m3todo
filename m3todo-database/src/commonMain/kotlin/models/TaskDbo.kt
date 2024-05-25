package com.github.mukiva.m3todo.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TaskDbo(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String
)