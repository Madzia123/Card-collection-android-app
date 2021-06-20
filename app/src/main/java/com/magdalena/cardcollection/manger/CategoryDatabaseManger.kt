package com.magdalena.cardcollection.manger

import com.magdalena.cardcollection.database.Category
import com.magdalena.cardcollection.database.CategoryDao

class CategoryDatabaseManger(val dao: CategoryDao) {

    fun insetCategories(categories: MutableList<Category>) = dao.insertCategories(categories)

    fun getCategories() = dao.getCategories()

    fun updateCategory(category: Category) = dao.updateCategory(category)

    fun deleteCategory(category: Category) = dao.deleteCategory(category)

    fun getCategoryId(categoryId: Long) = dao.getCategory(categoryId)

}