package com.magdalena.cardcollection

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.magdalena.cardcollection.database.Category
import com.magdalena.cardcollection.inject.AppComponent
import com.magdalena.cardcollection.inject.ContextModule
import com.magdalena.cardcollection.inject.DaggerAppComponent
import com.magdalena.cardcollection.manger.CardDatabaseManger
import com.magdalena.cardcollection.manger.CategoryDatabaseManger
import com.magdalena.cardcollection.utils.ItemsHelper
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class App : Application() {
    val disposables = CompositeDisposable()

    @Inject
    lateinit var categoryDatabaseManger: CategoryDatabaseManger


    companion object {
        lateinit var injector: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        injector = DaggerAppComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
        injector.inject(this)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        insetCategoryDatabase()
    }

    private fun insetCategoryDatabase() {
        disposables.add(
            Observable.fromCallable {
                categoryDatabaseManger.insetCategories(ItemsHelper.categoryList())
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({

                }, {

                })
        )
    }


}