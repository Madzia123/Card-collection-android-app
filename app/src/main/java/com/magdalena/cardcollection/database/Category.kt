package com.magdalena.cardcollection.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    @ColumnInfo()
    val name:String
)
