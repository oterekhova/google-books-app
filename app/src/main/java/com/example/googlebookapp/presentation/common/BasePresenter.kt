package com.example.googlebookapp.presentation.common

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class BasePresenter<V : BaseView> : MvpPresenter<V>() {

    private val compositeDisposable = CompositeDisposable()
    protected val logger: Logger = LoggerFactory.getLogger(javaClass.simpleName)

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    protected fun Disposable.unsubscribeOnDestroy() {
        compositeDisposable.add(this)
    }

}
