package com.example.googlebookapp.presentation.di.component

import com.example.googlebookapp.domain.model.BookModel
import com.example.googlebookapp.presentation.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun bookModel(): BookModel

}