package com.example.googlebookapp.domain.implementation

import com.example.googlebookapp.data.entity.BookEntity
import com.example.googlebookapp.data.network.GoogleApi
import com.example.googlebookapp.domain.repository.BookRepository
import io.reactivex.Single
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(private val api: GoogleApi) : BookRepository {

    companion object {
        const val KEY_VALUE: String = "AIzaSyAhE836RaDX8UU2G32Y0gESapfI0GoagoI"
    }

    override fun request(searchValue: String): Single<ArrayList<BookEntity>> {
        return api.search(searchValue, KEY_VALUE).map { response ->
            response?.books
        }
    }

}