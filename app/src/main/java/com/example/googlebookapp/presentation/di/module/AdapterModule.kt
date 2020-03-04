package com.example.googlebookapp.presentation.di.module

import com.example.googlebookapp.presentation.main.MainAdapter
import dagger.Module
import dagger.Provides


@Module
class AdapterModule {

    @Provides
    fun provideAdapter(): MainAdapter {
        return MainAdapter()
    }

}