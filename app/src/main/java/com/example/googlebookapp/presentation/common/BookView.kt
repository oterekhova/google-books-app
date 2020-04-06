package com.example.googlebookapp.presentation.common

import com.example.googlebookapp.data.entity.BookEntity
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BookView : BaseView {

    fun showData(books: ArrayList<BookEntity>)

    fun onShowDataFailure(error: String)

}