package com.magdalena.cardcollection.ui.addCard

import com.magdalena.cardcollection.database.Card
import com.magdalena.cardcollection.manger.CardDatabaseManger
import com.magdalena.cardcollection.ui.base.BaseViewModel
import com.magdalena.cardcollection.ui.home.adapter.CardItem
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AddCardViewModel :BaseViewModel(){

    @Inject
    lateinit var categoryDatabaseManger: CardDatabaseManger

    fun saveCard(card: Card){
        disposables.add(
            Observable.fromCallable {
                categoryDatabaseManger.saveCard(card)
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({

                }, {

                })
        )
    }


    fun navigationToChooseCategory(){
        navigate?.navigate(AddCardFragmentDirections.navAddCardToNavChooseCategory())
    }
}