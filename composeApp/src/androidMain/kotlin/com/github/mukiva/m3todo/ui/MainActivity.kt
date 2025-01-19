package com.github.mukiva.m3todo.ui

import App
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.defaultComponentContext
import com.github.mukiva.m3todo.di.androidModule
import org.koin.compose.KoinApplication
import org.koin.dsl.module

class MainActivity : AppCompatActivity() {

    private val activityModule = androidModule + module {
        single<ComponentContext> { defaultComponentContext() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinApplication(
                moduleList = { activityModule }
            ) {
                App()
            }
        }
    }
}