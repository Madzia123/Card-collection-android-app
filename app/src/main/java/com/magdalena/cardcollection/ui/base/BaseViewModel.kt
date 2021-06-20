package com.magdalena.cardcollection.ui.base

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController


abstract class BaseViewModel : ViewModel() {

    var navigate: NavController? = null

    init {
        inject()
    }

    private fun inject() {
        when (this) {

        }

    }

}