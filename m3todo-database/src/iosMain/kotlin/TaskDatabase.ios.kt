package com.gihub.mukiva.m3todo.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

internal actual fun createPlatformDatabase(): AbstractTaskDatabase {
    val dbFile = NSHomeDirectory() + "/task.db"
    return Room.databaseBuilder(
        name = dbFile,
        factory = { AbstractTaskDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}