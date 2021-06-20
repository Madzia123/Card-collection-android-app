package com.magdalena.cardcollection.database

import androidx.room.*

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(card: Card)

    @Update
    fun updateCard(card: Card)

    @Delete
    fun deleteCard(card: Card)
}