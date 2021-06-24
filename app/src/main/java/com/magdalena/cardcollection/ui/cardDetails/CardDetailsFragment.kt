package com.magdalena.cardcollection.ui.cardDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.magdalena.cardcollection.R
import com.magdalena.cardcollection.databinding.FragmentCardDetailBinding
import com.magdalena.cardcollection.databinding.FragmentSplashScreenBinding
import com.magdalena.cardcollection.ui.base.BaseFragment

class CardDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentCardDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        toolbarTitle = getString(R.string.add_card)
    }

}