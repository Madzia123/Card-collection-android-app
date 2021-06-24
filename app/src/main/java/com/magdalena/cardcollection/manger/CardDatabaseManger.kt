package com.magdalena.cardcollection.manger


import com.magdalena.cardcollection.database.Card
import com.magdalena.cardcollection.database.CardDao


class CardDatabaseManger(val dao: CardDao) {

    fun saveCard(card: Card) =
        dao.insertCard(card)

    fun getCards() = dao.getListCard()


    fun getCardDetail(cardId: Long?) = dao.getCardDetail(cardId)

    fun deleteCard(card: Card) = dao.deleteCard(card)

    fun updateCard(card: Card) = dao.updateCard(card)

    fun isFavoriteCard(cardId: Long?, isFavoriteCard: Boolean) =
        dao.isFavoriteCard(isFavoriteCard, cardId)
}