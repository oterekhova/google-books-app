package com.example.googlebookapp.presentation.di

import com.example.googlebookapp.presentation.di.component.AppComponent

import com.example.googlebookapp.presentation.di.component.DaggerAppComponent

object Injector {

    lateinit var appComponent: AppComponent

    fun init() {
        appComponent = DaggerAppComponent.create()
    }

}