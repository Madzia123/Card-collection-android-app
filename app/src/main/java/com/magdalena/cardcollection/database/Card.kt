package com.magdalena.cardcollection.database

data class Card(
    var id:Long,
    var numberCard:String,
    val typBarcode:String,
    var type:String,
    var categoryId:Int,
    val isFavorite:Boolean,
    val image:String,
    val createAt:String
)
