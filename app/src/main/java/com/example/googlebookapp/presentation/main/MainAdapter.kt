package com.example.googlebookapp.presentation.main

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.googlebookapp.R
import com.example.googlebookapp.data.entity.BookEntity
import com.example.googlebookapp.data.entity.BookInfoEntity
import com.example.googlebookapp.presentation.util.DiffUtilCallback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_book.view.*
import javax.inject.Inject


class MainAdapter @Inject constructor() : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var items: ArrayList<BookEntity> = ArrayList()

    fun updateData(newList: ArrayList<BookEntity>) {
        val diffUtilCallback = DiffUtilCallback(items, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)

        items.clear()
        items.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_book,
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
            view.bookAuthors.text = book.authors().joinToString(separator = ", ")
            view.bookDesc.text = book.description
            view.bookTitle.text = book.title
            Picasso.with(view.context)
                .load(Uri.parse(book.imageLinks.imageLink))
                .error(R.drawable.book_image)
                .into(view.bookImage)
        }

    }

}