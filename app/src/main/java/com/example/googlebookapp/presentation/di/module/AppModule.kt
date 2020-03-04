package com.example.googlebookapp.presentation.di.module

import com.example.googlebookapp.data.network.GoogleApi
import com.example.googlebookapp.data.network.RetrofitClient
import com.example.googlebookapp.domain.implementation.BookModelImpl
import com.example.googlebookapp.domain.implementation.BookRepositoryImpl
import com.example.googlebookapp.domain.model.BookModel
import com.example.googlebookapp.domain.repository.BookRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindBookRepository(bookRepositoryImpl: BookRepositoryImpl): BookRepository

    companion object {
        private const val BASE_URL = "https://www.googleapis.com/"

        @Singleton
        @Provides
        fun providesGoogleApi(): GoogleApi {
            return RetrofitClient(BASE_URL).get()
        }

        @Singleton
        @Provides
        fun providesBookRepositoryImpl(api: GoogleApi): BookRepositoryImpl {
            return BookRepositoryImpl(api)
        }

        @Singleton
        @Provides
        fun providesBookModel(bookRepository: BookRepository): BookModel {
            return BookModelImpl(bookRepository)
        }
    }
}