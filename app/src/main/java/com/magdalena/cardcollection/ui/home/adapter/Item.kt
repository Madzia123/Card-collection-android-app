package com.magdalena.cardcollection.ui.home.adapter

import com.magdalena.cardcollection.database.Card

sealed class Item
data class HeaderItem(var title: String) : Item()
data class CardItem(var card: Card) : Item()

