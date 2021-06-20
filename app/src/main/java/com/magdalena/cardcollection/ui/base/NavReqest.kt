package com.magdalena.cardcollection.ui

import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.inverce.mod.v2.core.IMEx.activity
import com.inverce.mod.v2.core.resources


data class NavRequest(@IdRes val id: Int) {
    constructor(directions: NavDirections) : this(0) {
        this.directions = directions
    }

    var directions: NavDirections? = null
    var finishCurrentActivity: Boolean = false

    fun navigate(navigationHost: NavController) {
        directions?.let {
            navigationHost.navigate(it)
        } ?: navigationHost.navigate(id)

        if (finishCurrentActivity) {
            activity?.finish()
        }
    }

    override fun toString(): String {
        val idTxt = if (id != 0) "id=${resources.getResourceName(id)}," else ""
        val dirTxt = if (directions != null) "directions=$directions" else ""
        return "NavRequest[$idTxt$dirTxt]"
    }
}

interface Navigator {
    fun navigate(request: NavRequest)
}

interface NavigatorProxy : Navigator {
    var navigatorProxy: Navigator?
}

interface NavigatorHost : Navigator {
    val navigationHost: NavController
}

class NavigatorProxyImpl : NavigatorProxy {
    override var navigatorProxy: Navigator? = null
    override fun navigate(request: NavRequest) = navigatorProxy?.navigate(request) ?: Unit
}