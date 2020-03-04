package com.example.googlebookapp.presentation.di.component

import com.example.googlebookapp.presentation.di.module.AdapterModule
import com.example.googlebookapp.presentation.main.MainActivity
import dagger.Component


@Component(modules = [AdapterModule::class])
interface ActivityComponent {

    fun mainActivity(mainActivity: MainActivity)

}