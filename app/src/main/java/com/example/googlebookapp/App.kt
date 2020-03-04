package com.example.googlebookapp

import android.app.Application
import com.example.googlebookapp.presentation.di.Injector


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.init()
    }

}