package com.magdalena.cardcollection.ui.home

import androidx.lifecycle.MutableLiveData
import com.magdalena.cardcollection.database.Card
import com.magdalena.cardcollection.manger.CardDatabaseManger
import com.magdalena.cardcollection.ui.base.BaseViewModel
import com.magdalena.cardcollection.ui.home.adapter.CardItem
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel : BaseViewModel() {

    @Inject
    lateinit var categoryDatabaseManger: CardDatabaseManger

    val cards: MutableLiveData<MutableList<CardItem>> = MutableLiveData()
    val cardItems: MutableList<CardItem> = mutableListOf()

    init {
        getListCard()
    }

    private fun getListCard() {
        cardItems.clear()

        disposables.add(
            Observable.fromCallable {
                categoryDatabaseManger.getCards()
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    it.forEach {
                        cardItems.add(CardItem(it))
                    }
                    cards.value = cardItems
                }, {

                })
        )
    }


    fun setFavoriteCard(isFavorite: Boolean, cardId: Long?) {
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