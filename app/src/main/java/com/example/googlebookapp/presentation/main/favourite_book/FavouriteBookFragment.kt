package com.example.googlebookapp.presentation.main.favourite_book

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


class FavouriteBookFragment : BaseFragment(),
    BookView {

    @Inject
    lateinit var mainAdapter: MainAdapter

    @InjectPresenter
    lateinit var favouriteBookPresenter: FavouriteBookPresenter

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
        favouriteBookPresenter.loadData()
    }

    override fun showData(books: ArrayList<BookEntity>) {
        mainAdapter.updateData(books)
    }

    override fun onShowDataFailure(error: String) {
        showMessage(error)
    }

    companion object {
        fun newInstance() = FavouriteBookFragment()
    }

}