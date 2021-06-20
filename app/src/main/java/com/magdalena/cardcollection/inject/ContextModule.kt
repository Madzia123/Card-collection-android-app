package com.magdalena.cardcollection.inject

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(val context: Context) {
    @Provides
    fun providesContext() = context
}