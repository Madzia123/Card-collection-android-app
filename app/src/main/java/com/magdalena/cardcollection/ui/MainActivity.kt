package com.magdalena.cardcollection.ui

import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.zxing.BarcodeFormat
import com.google.zxing.oned.Code128Writer
import com.magdalena.cardcollection.R
import com.magdalena.cardcollection.ui.base.NavigationInteraction
import com.magdalena.cardcollection.ui.base.ToolbarInteraction


class MainActivity : AppCompatActivity(), NavigationInteraction, ToolbarInteraction {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getNavigationController(): NavController {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return navHostFragment.navController
    }

    override fun showToolbarTitle(isVisibleTitle: Boolean) {

    }

    override fun isVisibleToolbar(isVisible: Boolean) {

    }

    override fun setToolbarTitle(toolbarTitle: String) {

    }


}