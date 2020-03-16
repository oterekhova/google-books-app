package com.example.googlebookapp.presentation.main

import com.example.googlebookapp.data.entity.BookEntity
import com.example.googlebookapp.presentation.common.BaseView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(OneExecutionStateStrategy::class)
interface MainView : BaseView {

    fun showData(book: List<BookEntity>)

    fun onShowDataFailure(error: String)

}