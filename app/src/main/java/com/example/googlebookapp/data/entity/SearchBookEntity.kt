package com.example.googlebookapp.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SearchBookEntity constructor(
    @SerializedName("items") var books: ArrayList<BookEntity>
) : Serializable