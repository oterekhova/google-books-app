package com.example.googlebookapp.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BookEntity constructor(
    @SerializedName("id") var id: String,
    @SerializedName("volumeInfo") var bookInfo: BookInfoEntity
) : Serializable