package com.magdalena.cardcollection.ui.home.adapter.card

interface CardListener {
    fun setFavoriteCard(isFavoriteCard: Boolean, cardId: Long?)
}