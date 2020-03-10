package com.example.googlebookapp.presentation.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googlebookapp.R
import com.example.googlebookapp.data.entity.BookEntity
import com.example.googlebookapp.domain.model.BookModel
import com.example.googlebookapp.presentation.common.BaseFragment
import com.example.googlebookapp.presentation.di.Injector
import kotlinx.android.synthetic.main.search_fragment.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject


class SearchFragment : BaseFragment(), MainView {

    companion object {
        fun newInstance() = SearchFragment()
    }

    @Inject
    lateinit var mainAdapter: MainAdapter

    @Inject
    lateinit var bookModel: BookModel

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    @ProvidePresenter
    fun provideMainPresenter() = MainPresenter(bookModel)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainAdapter = Injector.activityComponent.mainAdapter()
        bookModel = Injector.appComponent.bookModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (view != null) {
            view
        } else {
            inflater.inflate(R.layout.search_fragment, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        book_recycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = mainAdapter
        }
        mainPresenter.loadData("Снегурочка")
    }

    override fun showData(book: List<BookEntity>) {
        mainAdapter.items = book
    }

}