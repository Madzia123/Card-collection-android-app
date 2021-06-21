package com.magdalena.cardcollection.utils


import com.magdalena.cardcollection.R
import com.magdalena.cardcollection.ui.home.adapter.menu.MenuItem

object ItemsHelper {

    fun menuList(): MutableList<MenuItem> {
        val menuLists: MutableList<MenuItem> = mutableListOf()
        menuLists.add(MenuItem(R.drawable.ic_favorite, R.string.list_card, R.id.nav_home))
        menuLists.add(MenuItem(R.drawable.ic_favorite, R.string.add_card, R.id.nav_add_card))
        menuLists.add(MenuItem(R.drawable.ic_favorite, R.string.settings, R.id.nav_settings))
        menuLists.add(MenuItem(R.drawable.ic_favorite, R.string.about_app, R.id.nav_about_application))
        return menuLists
    }

}