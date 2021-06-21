package com.magdalena.cardcollection.database

import androidx.room.*

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(card: Card)

    @Query("SELECT * FROM card")
    fun getListCard(): MutableList<Card>

    @Update
    fun updateCard(card: Card)

    @Delete
    fun deleteCard(card: Card)

    @Query("UPDATE card SET isFavorite = :isFavorite WHERE id = :cardId")
    fun isFavoriteCard(isFavorite: Boolean, cardId: Long?)

}