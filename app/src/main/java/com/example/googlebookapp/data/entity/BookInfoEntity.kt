package com.example.googlebookapp.data.entity

import com.google.gson.annotations.SerializedName

data class BookInfoEntity constructor(
    @SerializedName("title") var title: String,
    @SerializedName("authors") var authors: List<String>,
    @SerializedName("description") var description: String,
    @SerializedName("imageLinks") var imageLinks: ImageLinks
) {

    fun authors(): List<String> {
        return if (authors.isNullOrEmpty()) {
            arrayListOf("Unknown authors")
        } else {
            authors
        }
    }

}