package com.magdalena.cardcollection.database

import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(card: Card)

    @Query("SELECT * FROM card")
    fun getListCard(): MutableList<Card>

    @Query("SELECT * FROM card WHERE id =:cardId LIMIT 1")
    fun getCardDetail(cardId: Long?): MutableLiveData<Card>

    @Update
    fun updateCard(card: Card)

    @Delete
    fun deleteCard(card: Card)

    @Query("UPDATE card SET isFavorite = :isFavorite WHERE id = :cardId")
    fun isFavoriteCard(isFavorite: Boolean, cardId: Long?)

}