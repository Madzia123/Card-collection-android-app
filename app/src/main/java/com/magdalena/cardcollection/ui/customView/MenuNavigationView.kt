package com.magdalena.cardcollection.ui.customView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.magdalena.cardcollection.R
import com.magdalena.cardcollection.databinding.ActivityMainBinding.inflate
import com.magdalena.cardcollection.databinding.FragmentCardDetailBinding.inflate
import com.magdalena.cardcollection.databinding.MenuNavigationViewBinding
import com.magdalena.cardcollection.ui.home.adapter.CardAdapter

class MenuNavigationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var cardAdapter: CardAdapter
    private var binding: MenuNavigationViewBinding

    init {
        binding = MenuNavigationViewBinding.inflate(LayoutInflater.from(context), this, true)
        addView(binding.root)
    }


}