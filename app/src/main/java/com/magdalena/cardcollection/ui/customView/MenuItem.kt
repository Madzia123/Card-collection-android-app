package com.magdalena.cardcollection.ui.customView

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