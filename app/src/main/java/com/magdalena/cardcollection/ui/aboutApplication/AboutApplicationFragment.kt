package com.magdalena.cardcollection.ui.aboutApplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.magdalena.cardcollection.R
import com.magdalena.cardcollection.databinding.FragmantAboutApplicationBinding
import com.magdalena.cardcollection.databinding.FragmentAddCardBinding
import com.magdalena.cardcollection.ui.base.BaseFragment

class AboutApplicationFragment : BaseFragment() {

    private lateinit var binding: FragmantAboutApplicationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmantAboutApplicationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        toolbarTitle = getString(R.string.about_app)
    }
}