package com.magdalena.cardcollection.ui.chooseCategory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magdalena.cardcollection.database.Category
import com.magdalena.cardcollection.databinding.ItemCategoryBinding
import com.magdalena.cardcollection.ui.base.BaseRecyclerViewAdapter

class ChooseCategoryAdapter : BaseRecyclerViewAdapter<Category, ChooseCategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: CategoryViewHolder, item: Category, position: Int) {
        holder.binding.apply {
            categoryItem.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }


}