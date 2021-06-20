package com.magdalena.cardcollection.database

import androidx.room.*

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(card: MutableList<Category>)

    @Query("SELECT * FROM category")
    fun getCategories(): MutableList<Category>

    @Update
    fun updateCategory(card: Category)

    @Delete
    fun deleteCategory(card: Category)

}