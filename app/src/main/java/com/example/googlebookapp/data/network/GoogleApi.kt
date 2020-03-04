package com.example.googlebookapp.data.network

import com.example.googlebookapp.data.entity.SearchBookEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleApi {

    @GET("books/v1/volumes")
    fun search(
        @Query("q") searchValue: String,
        @Query("key") keyValue: String
    ): Single<SearchBookEntity>

}