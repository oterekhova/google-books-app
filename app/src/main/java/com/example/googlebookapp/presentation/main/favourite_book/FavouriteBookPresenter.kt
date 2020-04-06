package com.example.googlebookapp.presentation.main.favourite_book

import com.example.googlebookapp.presentation.common.BasePresenter
import com.example.googlebookapp.presentation.common.BookView
import com.example.googlebookapp.presentation.di.Injector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject


@InjectViewState
class FavouriteBookPresenter @Inject constructor() :
    BasePresenter<BookView>() {

    fun loadData() {
        bookModel = Injector.appComponent.bookModel()
        bookModel.getFavouriteList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { viewState.showData(it) },
                { viewState.onShowDataFailure(it.message.orEmpty()) })
            .unsubscribeOnDestroy()
    }

}