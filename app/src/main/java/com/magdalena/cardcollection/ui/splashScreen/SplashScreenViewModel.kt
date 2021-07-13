package com.magdalena.cardcollection.ui.splashScreen

import com.magdalena.cardcollection.manger.CategoryDatabaseManger
import com.magdalena.cardcollection.ui.base.BaseViewModel
import com.magdalena.cardcollection.utils.ItemsHelper
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SplashScreenViewModel : BaseViewModel() {




    fun navigationToListCard() {
        navigate?.navigate(SplashScreenFragmentDirections.navSplashScreenToNavHome())
    }




}