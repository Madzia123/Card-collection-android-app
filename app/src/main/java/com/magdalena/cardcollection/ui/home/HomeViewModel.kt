package com.magdalena.cardcollection.ui.home

import com.magdalena.cardcollection.manger.CardDatabaseManger
import com.magdalena.cardcollection.ui.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel : BaseViewModel() {

    @Inject
    lateinit var categoryDatabaseManger: CardDatabaseManger


    fun setFavoriteCard(isFavorite: Boolean, cardId: Long) {
        disposables.add(
            Observable.fromCallable {
                categoryDatabaseManger.isFavoriteCard(cardId, isFavorite)
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({

                }, {


                })
        )
    }


}