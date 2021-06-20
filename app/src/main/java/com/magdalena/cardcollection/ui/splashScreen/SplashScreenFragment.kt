package com.magdalena.cardcollection.ui.splashScreen

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.magdalena.cardcollection.databinding.FragmentSplashScreenBinding
import com.magdalena.cardcollection.ui.base.BaseFragment

class SplashScreenFragment : BaseFragment() {

    private lateinit var binding: FragmentSplashScreenBinding
    private lateinit var viewModel: SplashScreenViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(SplashScreenViewModel::class.java)
        viewModel.navigate = navigate
        binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            viewModel.navigationToListCard()
        }, 700)

    }


    override fun onResume() {
        super.onResume()
        toolbarVisible = false
    }
}