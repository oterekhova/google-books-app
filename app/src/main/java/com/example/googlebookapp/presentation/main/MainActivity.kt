package com.example.googlebookapp.presentation.main

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.googlebookapp.R
import com.example.googlebookapp.presentation.common.BaseView
import com.example.googlebookapp.presentation.main.favourite_book.FavouriteBookFragment
import com.example.googlebookapp.presentation.main.search_book.SearchBookFragment
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setUpViewPager(viewPager as ViewPager)
    }

    private fun setUpViewPager(viewPager: ViewPager) {
        val adapter = ViewPageAdapter(supportFragmentManager)
        adapter.addFragment(SearchBookFragment.newInstance(), "Поиск")
        adapter.addFragment(FavouriteBookFragment.newInstance(), "Избранное")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
        tabs.getTabAt(0)?.setIcon(R.drawable.search_black)
        tabs.getTabAt(1)?.setIcon(R.drawable.favorite_border_black)
    }

}
