package com.example.googlebookapp.presentation.main

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.googlebookapp.R
import com.example.googlebookapp.data.entity.BookEntity
import com.example.googlebookapp.domain.model.BookModel
import com.example.googlebookapp.presentation.di.Injector
import com.example.googlebookapp.presentation.util.DiffUtilCallback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_book.view.*
import javax.inject.Inject


class MainAdapter @Inject constructor() :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var items: ArrayList<BookEntity> = ArrayList()

    @Inject
    lateinit var bookModel: BookModel

    fun updateData(newList: ArrayList<BookEntity>) {
        val diffUtilCallback = DiffUtilCallback(items, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)

        items.clear()
        items.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        bookModel = Injector.appComponent.bookModel()
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
        viewHolder.bind(items[position])
    }

    inner class MainViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(book: BookEntity) {
            view.bookAuthors.text = book.bookInfo.authors().joinToString(separator = ", ")
            view.bookDesc.text = book.bookInfo.description
            view.bookTitle.text = book.bookInfo.title
            Picasso.with(view.context)
                .load(Uri.parse(book.bookInfo.imageLinks.imageLink))
                .error(R.drawable.book_image)
                .into(view.bookImage)
            view.likeButton.setOnClickListener(onClickListener(book))
        }

        private fun onClickListener(book: BookEntity): View.OnClickListener {
            return View.OnClickListener {
                if (view.likeButton.isChecked) {
                    bookModel.addToFavourite(book.id)
                    view.likeButton.isChecked = true
                } else {
                    bookModel.removeFromFavourite(book.id)
                    view.likeButton.isChecked = false
                }
            }
        }

    }

}
