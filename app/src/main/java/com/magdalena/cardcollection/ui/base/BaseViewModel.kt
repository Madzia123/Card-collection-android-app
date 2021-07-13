package com.magdalena.cardcollection.ui.base

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.magdalena.cardcollection.App.Companion.injector
import com.magdalena.cardcollection.ui.addCard.AddCardViewModel
import com.magdalena.cardcollection.ui.chooseCategory.ChooseCategoryViewModel
import com.magdalena.cardcollection.ui.home.HomeViewModel
import com.magdalena.cardcollection.ui.splashScreen.SplashScreenViewModel
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
            is SplashScreenViewModel -> injector.inject(this)
            is HomeViewModel -> injector.inject(this)
            is AddCardViewModel -> injector.inject(this)
            is ChooseCategoryViewModel -> injector.inject(this)
        }

    }

}