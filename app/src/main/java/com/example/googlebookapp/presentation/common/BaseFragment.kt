package com.example.googlebookapp.presentation.common

import android.app.AlertDialog
import moxy.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment() {

    protected fun showMessage(text: String) {
        AlertDialog.Builder(requireContext())
            .setCancelable(true)
            .setTitle(text)
            .setNegativeButton(android.R.string.ok) { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

}
