package com.example.googlebookapp.presentation.main

import com.example.googlebookapp.domain.model.BookModel
import com.example.googlebookapp.presentation.common.BasePresenter
import com.example.googlebookapp.presentation.di.Injector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class MainPresenter @Inject constructor() :
    BasePresenter<MainView>() {

    @Inject
    lateinit var bookModel: BookModel

    fun loadData(value: String) {
        bookModel = Injector.appComponent.bookModel()
        bookModel.searchBooks(value).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ viewState.showData(it) },
                { logger.error("Error:", it) })
            .unsibscribeOnDestroy()
    }

}