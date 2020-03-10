package com.example.googlebookapp.presentation.main

import com.example.googlebookapp.domain.model.BookModel
import com.example.googlebookapp.presentation.common.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class MainPresenter @Inject constructor(private val bookModel: BookModel) :
    BasePresenter<MainView>() {

    fun loadData(value: String) {
        bookModel.searchBooks(value)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { viewState.showData(it) },
                { logger.error("Error:", it) })
            .unsubscribeOnDestroy()
    }

}