package com.example.googlebookapp.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.googlebookapp.R
import com.example.googlebookapp.data.entity.BookEntity
import com.example.googlebookapp.domain.model.BookModel
import com.example.googlebookapp.presentation.di.Injector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

}
