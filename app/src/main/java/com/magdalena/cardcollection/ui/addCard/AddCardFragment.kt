package com.magdalena.cardcollection.ui.addCard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.zxing.integration.android.IntentIntegrator
import com.magdalena.cardcollection.R
import com.magdalena.cardcollection.databinding.FragmentAddCardBinding
import com.magdalena.cardcollection.databinding.FragmentSplashScreenBinding
import com.magdalena.cardcollection.ui.base.BaseFragment
import com.magdalena.cardcollection.utils.value

class AddCardFragment : BaseFragment() {

    private lateinit var binding: FragmentAddCardBinding

    private var isFavoriteCard = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setFavoriteCard.setOnClickListener {
            isFavoriteCard = !isFavoriteCard
            binding.cardFavorite.setImageResource(if (isFavoriteCard) R.drawable.ic_favorite else R.drawable.ic_un_favorite)
        }
    }


override fun onResume() {
    super.onResume()
    toolbarTitle = getString(R.string.add_card)
}

}