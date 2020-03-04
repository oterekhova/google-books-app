package com.example.googlebookapp.presentation.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.googlebookapp.R
import com.example.googlebookapp.data.entity.BookEntity
import com.example.googlebookapp.data.entity.BookInfoEntity
import kotlinx.android.synthetic.main.item_book_list.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class MainAdapter @Inject constructor() : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var items: List<BookEntity> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_book_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(viewHolder: MainViewHolder, position: Int) {
        viewHolder.bind(items[position].bookInfo)
    }

    inner class MainViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(book: BookInfoEntity) {
            view.book_image.text = book.imageLinks.imageLink
            view.book_authors.text = "${book.authors}"
            view.book_desc.text = book.description
            view.book_title.text = book.title
        }

    }

}