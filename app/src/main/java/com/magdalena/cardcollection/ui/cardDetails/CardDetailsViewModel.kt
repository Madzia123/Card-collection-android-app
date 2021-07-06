package com.magdalena.cardcollection.ui.cardDetails

import com.magdalena.cardcollection.manger.CardDatabaseManger
import com.magdalena.cardcollection.ui.base.BaseViewModel
import com.magdalena.cardcollection.ui.home.adapter.CardItem
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CardDetailsViewModel:BaseViewModel() {

    @Inject
    lateinit var categoryDatabaseManger: CardDatabaseManger

    fun getCardDetails(cardId:Long){
        disposables.add(
            Observable.fromCallable {
                categoryDatabaseManger.getCardDetail(cardId)
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({

                }, {

                })
        )
    }
}