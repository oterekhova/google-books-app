package com.example.googlebookapp.data.entity

import com.google.gson.annotations.SerializedName

data class SearchBookEntity constructor(
    @SerializedName("items") var books: List<BookEntity>
)