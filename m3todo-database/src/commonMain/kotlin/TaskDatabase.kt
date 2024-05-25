package com.gihub.mukiva.m3todo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.mukiva.m3todo.database.dao.ITaskDao
import com.github.mukiva.m3todo.database.models.TaskDbo

@Database(
    entities = [TaskDbo::class],
    version = 1
)
internal abstract class AbstractTaskDatabase : RoomDatabase() {

    abstract val taskDao: ITaskDao

}

internal expect fun createPlatformDatabase(): AbstractTaskDatabase

class DatabaseWrapper internal constructor(
    private val database: AbstractTaskDatabase
) {
    val taskDao: ITaskDao
        get() = database.taskDao
}

fun createDatabase(): DatabaseWrapper {
    val nativeDatabase = createPlatformDatabase()
    return DatabaseWrapper(nativeDatabase)
}