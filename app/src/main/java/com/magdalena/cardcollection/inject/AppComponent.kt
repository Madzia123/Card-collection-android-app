package com.magdalena.cardcollection.inject

import com.magdalena.cardcollection.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class,RoomModule::class])
interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun contextModule(contextModule: ContextModule): Builder
    }

}