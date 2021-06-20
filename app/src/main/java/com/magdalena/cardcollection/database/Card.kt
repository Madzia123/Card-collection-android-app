package com.magdalena.cardcollection.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card")
data class Card(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    @ColumnInfo()
    val numberCard: String,
    @ColumnInfo()
    val typBarcode: String,
    @ColumnInfo()
    var type: String,
    @ColumnInfo()
    var categoryId: Int,
    @ColumnInfo()
    val isFavorite: Boolean,
    @ColumnInfo()
    val image: String? = null,
    @ColumnInfo()
    val createAt: String
)
