package com.magdalena.cardcollection.inject

import com.magdalena.cardcollection.App
import com.magdalena.cardcollection.ui.addCard.AddCardViewModel
import com.magdalena.cardcollection.ui.cardDetails.CardDetailsViewModel
import com.magdalena.cardcollection.ui.chooseCategory.ChooseCategoryViewModel
import com.magdalena.cardcollection.ui.home.HomeViewModel
import com.magdalena.cardcollection.ui.splashScreen.SplashScreenViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class,RoomModule::class])
interface AppComponent {

    fun inject(app: App)
    fun inject(addCardViewModel: AddCardViewModel)
    fun inject(homeViewModel: HomeViewModel)
    fun inject (chooseCategoryViewModel: ChooseCategoryViewModel)
    fun inject(cardDetailsViewModel: CardDetailsViewModel)
    fun inject(splashScreenViewModel: SplashScreenViewModel)


    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun contextModule(contextModule: ContextModule): Builder
    }

}