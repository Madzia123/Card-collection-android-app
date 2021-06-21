package com.magdalena.cardcollection.ui.customView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.magdalena.cardcollection.databinding.ItemMenuBinding
import com.magdalena.cardcollection.ui.base.BaseRecyclerViewAdapter

class MenuNavigationAdapter(val navigation: NavController) :
    BaseRecyclerViewAdapter<MenuItem, MenuNavigationAdapter.MenuViewHolder>() {

    class MenuViewHolder(val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MenuViewHolder, item: MenuItem, position: Int) {
        holder.binding.apply {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }


}