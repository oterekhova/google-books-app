package com.example.googlebookapp.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BookInfoEntity constructor(
    @SerializedName("title") var title: String,
    @SerializedName("authors") var authors: ArrayList<String>,
    @SerializedName("description") var description: String,
    @SerializedName("imageLinks") var imageLinks: ImageLinks
) : Serializable {

    fun authors(): ArrayList<String> {
        return if (authors.isNullOrEmpty()) {
            arrayListOf("Unknown authors")
        } else {
            authors
        }
    }

}