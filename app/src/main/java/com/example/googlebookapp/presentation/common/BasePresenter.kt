package com.example.googlebookapp.presentation.common

import com.example.googlebookapp.domain.model.BookModel
import com.example.googlebookapp.presentation.di.Injector
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Inject

abstract class BasePresenter<V : BaseView> : MvpPresenter<V>() {

    private val compositeDisposable = CompositeDisposable()
    protected val logger: Logger = LoggerFactory.getLogger(javaClass.simpleName)

    @Inject
    lateinit var bookModel: BookModel

    override fun attachView(view: V) {
        super.attachView(view)
        bookModel = Injector.appComponent.bookModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    protected fun Disposable.unsubscribeOnDestroy() {
        compositeDisposable.add(this)
    }

}
