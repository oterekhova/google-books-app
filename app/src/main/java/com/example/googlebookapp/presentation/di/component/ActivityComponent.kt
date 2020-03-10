package com.example.googlebookapp.presentation.di.component

import com.example.googlebookapp.presentation.di.module.AdapterModule
import com.example.googlebookapp.presentation.main.MainAdapter
import dagger.Component


@Component(modules = [AdapterModule::class])
interface ActivityComponent {

    fun mainAdapter(): MainAdapter

}