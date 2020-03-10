package com.example.googlebookapp.domain.repository

import com.example.googlebookapp.data.entity.BookEntity
import io.reactivex.Single

interface BookRepository {

    fun request(searchValue: String): Single<List<BookEntity>>

}