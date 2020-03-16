package com.example.googlebookapp.presentation.common

import android.app.AlertDialog
import com.example.googlebookapp.presentation.main.MainActivity
import moxy.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment() {

    protected val mainActivity: MainActivity get() = activity as MainActivity

    protected fun showMessage(text: String) {
        AlertDialog.Builder(mainActivity)
            .setCancelable(true)
            .setTitle(text)
            .setNegativeButton(android.R.string.ok) { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

}
