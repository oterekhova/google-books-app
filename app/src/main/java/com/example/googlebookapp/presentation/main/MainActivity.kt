package com.example.googlebookapp.presentation.main

import android.os.Bundle
import com.example.googlebookapp.R
import com.example.googlebookapp.presentation.common.BaseView
import com.example.googlebookapp.presentation.main.search_book.SearchBookFragment
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            setSupportActionBar(toolbar)
            displaySearchFragment()
        }
    }

    private fun displaySearchFragment() {
        val searchFragment = SearchBookFragment.newInstance()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition
            .replace(R.id.search_frame, searchFragment)
            .commit()
    }

}
