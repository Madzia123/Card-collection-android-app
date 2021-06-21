package com.magdalena.cardcollection.ui.home.adapter.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.magdalena.cardcollection.databinding.ItemMenuBinding
import com.magdalena.cardcollection.ui.base.BaseRecyclerViewAdapter
import java.lang.ref.WeakReference

class MenuNavigationAdapter(val navigation: NavController) :
    BaseRecyclerViewAdapter<MenuItem, MenuNavigationAdapter.MenuViewHolder>() {

    var listenerMenu: WeakReference<MenuNavigationListener>? = null

    fun setListenerMenu(listener: MenuNavigationListener) {
        this.listenerMenu = WeakReference(listener)
    }

    class MenuViewHolder(val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MenuViewHolder, item: MenuItem, position: Int) {
        holder.binding.apply {
            menuIcon.setImageResource(item.icon)
            menuText.setText(item.titleMenu)
            itemContentView.setOnClickListener {
                item.action(navigation)
                listenerMenu?.get()?.closeMenu()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }


}