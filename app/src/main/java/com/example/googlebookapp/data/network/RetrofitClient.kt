package com.example.googlebookapp.data.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitClient @Inject constructor(private val endpoint: String) {

    fun get(): GoogleApi {
        return Retrofit.Builder()
            .baseUrl(endpoint)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GoogleApi::class.java)
    }

}