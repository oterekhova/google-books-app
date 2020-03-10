package com.example.googlebookapp.domain.implementation

import com.example.googlebookapp.data.entity.BookEntity
import com.example.googlebookapp.domain.model.BookModel
import com.example.googlebookapp.domain.repository.BookRepository
import io.reactivex.Single
import javax.inject.Inject

class BookModelImpl @Inject constructor(private val repository: BookRepository) :
    BookModel {

    override fun searchBooks(searchValue: String): Single<List<BookEntity>> {
        return repository.request(searchValue)
    }

}