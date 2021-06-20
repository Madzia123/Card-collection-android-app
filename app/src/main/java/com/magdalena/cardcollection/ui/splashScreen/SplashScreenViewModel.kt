package com.magdalena.cardcollection.ui.splashScreen

import com.magdalena.cardcollection.ui.base.BaseViewModel

class SplashScreenViewModel : BaseViewModel() {

    fun navigationToListCard(){
        navigate?.navigate(SplashScreenFragmentDirections.navSplashScreenToNavHome())
    }
}