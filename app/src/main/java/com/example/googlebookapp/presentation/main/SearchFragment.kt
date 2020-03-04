package com.example.googlebookapp.presentation.main

import android.os.Bundle
import android.view.View
import com.example.googlebookapp.data.entity.BookEntity
import com.example.googlebookapp.presentation.common.BaseFragment
import moxy.presenter.InjectPresenter
import javax.inject.Inject


class SearchFragment : BaseFragment(), MainView {

    companion object {
        fun newInstance() = SearchFragment()
    }

    @Inject
    lateinit var mainAdapter: MainAdapter

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun showData(book: List<BookEntity>) {
        mainAdapter.items = book
    }

}