package com.magdalena.cardcollection.ui.chooseCategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.magdalena.cardcollection.R
import com.magdalena.cardcollection.databinding.FragmantChooseCategoryBinding
import com.magdalena.cardcollection.databinding.FragmentSplashScreenBinding
import com.magdalena.cardcollection.ui.base.BaseFragment
import com.magdalena.cardcollection.ui.splashScreen.SplashScreenViewModel
import com.magdalena.cardcollection.utils.ItemsHelper

class ChooseCategoryFragment : BaseFragment() {

    private lateinit var binding: FragmantChooseCategoryBinding
    private lateinit var viewModel: ChooseCategoryViewModel
    private lateinit var categoryAdapter: ChooseCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ChooseCategoryViewModel::class.java)
        viewModel.navigate = navigate
        binding = FragmantChooseCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryAdapter = ChooseCategoryAdapter()
        binding.categoryList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = categoryAdapter
        }

        viewModel.getCategories()

        viewModel.categories.observe(viewLifecycleOwner, Observer {
            categoryAdapter.data = it
        })

    }


    override fun onResume() {
        super.onResume()
        toolbarTitleRes = R.string.choose_category
    }

}