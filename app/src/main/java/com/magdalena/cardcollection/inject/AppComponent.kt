package com.magdalena.cardcollection.inject

import com.magdalena.cardcollection.App
import com.magdalena.cardcollection.ui.addCard.AddCardViewModel
import com.magdalena.cardcollection.ui.cardDetails.CardDetailsViewModel
import com.magdalena.cardcollection.ui.home.HomeViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class,RoomModule::class])
interface AppComponent {

    fun inject(app: App)
    fun inject(addCardViewModel: AddCardViewModel)
    fun inject(homeViewModel: HomeViewModel)
    fun inject(cardDetailsViewModel: CardDetailsViewModel)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun contextModule(contextModule: ContextModule): Builder
    }

}