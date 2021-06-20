package com.magdalena.cardcollection.ui.base

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseViewModel : ViewModel() {

    var disposable: Disposable? = null
    val disposables = CompositeDisposable()

    var navigate: NavController? = null

    init {
        inject()
    }

    private fun inject() {
        when (this) {

        }

    }

}