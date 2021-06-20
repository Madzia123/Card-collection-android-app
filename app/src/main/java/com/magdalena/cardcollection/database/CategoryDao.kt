package com.magdalena.cardcollection.database

import androidx.room.*

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(categories: MutableList<Category>)

    @Query("SELECT * FROM category")
    fun getCategories(): MutableList<Category>

    @Update
    fun updateCategory(card: Category)

    @Delete
    fun deleteCategory(card: Category)

    @Query("SELECT * FROM category WHERE id=:categoryId")
    fun getCategory(categoryId: Long): MutableList<Category>

}