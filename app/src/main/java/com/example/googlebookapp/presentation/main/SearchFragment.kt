package com.example.googlebookapp.presentation.main

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
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
        setHasOptionsMenu(true)
        book_recycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = mainAdapter
        }
    }

    override fun showData(book: List<BookEntity>) {
        mainAdapter.items = book
    }

    override fun onShowDataFailure(error: String) {
        showMessage(error)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        menu?.let {
            inflater?.inflate(R.menu.menu_main, menu)
            val searchView = menu.findItem(R.id.action_search).actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    mainPresenter.loadData(query)
                    return true
                }
            })
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

}