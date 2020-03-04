package com.example.googlebookapp.presentation.main

import com.example.googlebookapp.data.entity.BookEntity
import com.example.googlebookapp.presentation.common.BaseView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MainView : BaseView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showData(book: List<BookEntity>)

}