package com.example.googlebookapp.presentation.main.search_book

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googlebookapp.R
import com.example.googlebookapp.data.entity.BookEntity
import com.example.googlebookapp.presentation.common.BaseFragment
import com.example.googlebookapp.presentation.common.BookView
import com.example.googlebookapp.presentation.di.Injector
import com.example.googlebookapp.presentation.main.MainAdapter
import kotlinx.android.synthetic.main.books_view_fragment.*
import moxy.presenter.InjectPresenter
import javax.inject.Inject


class SearchBookFragment : BaseFragment(),
    BookView {

    @Inject
    lateinit var mainAdapter: MainAdapter

    @InjectPresenter
    lateinit var searchBookPresenter: SearchBookPresenter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mainAdapter = Injector.activityComponent.mainAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return view ?: inflater.inflate(R.layout.books_view_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        book_recycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mainAdapter
        }
    }

    override fun showData(books: ArrayList<BookEntity>) {
        mainAdapter.updateData(books)
    }

    override fun onShowDataFailure(error: String) {
        showMessage(error)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        menu?.let {safeMenu ->
            inflater?.inflate(R.menu.menu_main, safeMenu)
            val searchView = safeMenu.findItem(R.id.action_search).actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    searchBookPresenter.loadData(query)
                    return true
                }
            })
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    companion object {
        fun newInstance() = SearchBookFragment()
    }

}