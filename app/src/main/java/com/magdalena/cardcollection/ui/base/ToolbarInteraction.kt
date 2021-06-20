package com.magdalena.cardcollection.ui.base

interface ToolbarInteraction {
    fun showToolbarTitle(isVisibleTitle:Boolean)
    fun isVisibleToolbar(isVisible: Boolean)
    fun setToolbarTitle(toolbarTitle: String)
}