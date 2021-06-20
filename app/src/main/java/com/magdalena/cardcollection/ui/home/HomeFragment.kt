package com.magdalena.cardcollection.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.magdalena.cardcollection.R
import com.magdalena.cardcollection.databinding.FragmentHomeBinding
import com.magdalena.cardcollection.databinding.FragmentSplashScreenBinding
import com.magdalena.cardcollection.ui.base.BaseFragment

class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        toolbarVisible = true
        toolbarTitle = getString(R.string.list_card)
    }
}