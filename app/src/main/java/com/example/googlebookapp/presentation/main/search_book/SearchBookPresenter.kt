package com.example.googlebookapp.presentation.main.search_book

import com.example.googlebookapp.presentation.common.BasePresenter
import com.example.googlebookapp.presentation.common.BookView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class SearchBookPresenter @Inject constructor() :
    BasePresenter<BookView>() {

    fun loadData(value: String) {
        bookModel.searchBooks(value)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { viewState.showData(it) },
                { viewState.onShowDataFailure(it.message.orEmpty()) })
            .unsubscribeOnDestroy()
    }

}