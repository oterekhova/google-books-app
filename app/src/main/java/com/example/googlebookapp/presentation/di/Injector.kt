package com.example.googlebookapp.presentation.di

import com.example.googlebookapp.presentation.di.component.ActivityComponent
import com.example.googlebookapp.presentation.di.component.AppComponent
import com.example.googlebookapp.presentation.di.component.DaggerActivityComponent

import com.example.googlebookapp.presentation.di.component.DaggerAppComponent

object Injector {

    lateinit var appComponent: AppComponent
        private set

    lateinit var activityComponent: ActivityComponent
        private set

    fun init() {
        appComponent = DaggerAppComponent.create()
        activityComponent = DaggerActivityComponent.create()
    }

}