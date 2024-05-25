package com.gihub.mukiva.m3todo.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.koin.mp.KoinPlatform

internal actual fun createPlatformDatabase(): AbstractTaskDatabase {
    val context: Context = KoinPlatform.getKoin().get()
    val dbFile = context.getDatabasePath("task.db")
    return Room.databaseBuilder<AbstractTaskDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}