package com.magdalena.cardcollection.ui

import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.zxing.BarcodeFormat
import com.google.zxing.oned.Code128Writer
import com.magdalena.cardcollection.R
import com.magdalena.cardcollection.databinding.ActivityMainBinding
import com.magdalena.cardcollection.ui.base.NavigationInteraction
import com.magdalena.cardcollection.ui.base.ToolbarInteraction


class MainActivity : AppCompatActivity(), NavigationInteraction, ToolbarInteraction {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.menu.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
                binding.drawerLayout.closeDrawer(GravityCompat.END)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.END)
            }
        }
    }

    override fun getNavigationController(): NavController {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return navHostFragment.navController
    }

    override fun isVisibleToolbar(isVisible: Boolean) {
        binding.contentToolbar.isVisible = isVisible
    }

    override fun setToolbarTitle(toolbarTitle: String) {
        binding.titleView.text = toolbarTitle
    }


    override fun onBackPressed() {
        super.onBackPressed()
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
            binding.drawerLayout.closeDrawer(GravityCompat.END)
        } else {
            binding.drawerLayout.openDrawer(GravityCompat.END)
        }
    }

}