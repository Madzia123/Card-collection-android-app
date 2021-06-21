package com.magdalena.cardcollection.ui.home.adapter

interface CardListener {
    fun setFavoriteCard(isFavoriteCard: Boolean, cardId: Long?)
}