package com.example.googlebookapp.domain.model

import com.example.googlebookapp.data.entity.BookEntity
import io.reactivex.Single

interface BookModel {

    fun searchBooks(searchValue: String): Single<ArrayList<BookEntity>>

    fun addToFavourite(bookId: String)

    fun removeFromFavourite(bookId: String)

    fun getFavouriteList(): Single<ArrayList<BookEntity>>

}