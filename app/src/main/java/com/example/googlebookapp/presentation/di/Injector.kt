package com.example.googlebookapp.presentation.di

import com.example.googlebookapp.presentation.di.component.ActivityComponent
import com.example.googlebookapp.presentation.di.component.AppComponent
import com.example.googlebookapp.presentation.di.component.DaggerActivityComponent

import com.example.googlebookapp.presentation.di.component.DaggerAppComponent

object Injector {

    lateinit var appComponent: AppComponent
    lateinit var activityComponent: ActivityComponent

    fun init() {
        appComponent = DaggerAppComponent.create()
        activityComponent = DaggerActivityComponent.create()
    }

}