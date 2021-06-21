package com.magdalena.cardcollection.ui.home.adapter.menu

import androidx.navigation.NavController

class MenuItem(
    val icon: Int,
    val titleMenu: Int,
    var action: (NavController) -> Unit
) {

    constructor(icon: Int, titleMenu: Int, navigationId: Int?) : this(icon,
        titleMenu,
        {
            navigationId?.let { navigationId ->
                it.navigate(navigationId)
            }
        })
}