package com.example.googlebookapp.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ImageLinks(@SerializedName("smallThumbnail") var imageLink: String) : Serializable