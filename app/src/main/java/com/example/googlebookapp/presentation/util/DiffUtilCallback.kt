package com.example.googlebookapp.presentation.util

import androidx.recyclerview.widget.DiffUtil
import com.example.googlebookapp.data.entity.BookEntity

class DiffUtilCallback(
    private val oldList: ArrayList<BookEntity>,
    private val newList: ArrayList<BookEntity>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemPosition == newItemPosition
    }

    override fun getOldListSize(): Int {
        return oldList.size;
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList.get(oldItemPosition) == newList.get(newItemPosition)
    }

}