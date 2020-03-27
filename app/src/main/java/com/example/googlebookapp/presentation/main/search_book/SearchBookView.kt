package com.example.googlebookapp.presentation.main.search_book

import com.example.googlebookapp.data.entity.BookEntity
import com.example.googlebookapp.presentation.common.BaseView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface SearchBookView : BaseView {

    fun showData(books: ArrayList<BookEntity>)

    fun onShowDataFailure(error: String)

}