package com.magdalena.cardcollection.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.magdalena.cardcollection.R
import com.magdalena.cardcollection.databinding.FragmentHomeBinding
import com.magdalena.cardcollection.ui.base.BaseFragment
import com.magdalena.cardcollection.ui.home.adapter.CardAdapter
import com.magdalena.cardcollection.ui.home.adapter.CardListener

class HomeFragment : BaseFragment(), CardListener {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private lateinit var cardAdapter: CardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.navigate = navigate
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycleView()
    }

    private fun setRecycleView() {
        cardAdapter = CardAdapter()
        cardAdapter.setListener(this)
        binding.listCard.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cardAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        toolbarVisible = true
        toolbarTitle = getString(R.string.list_card)
    }

    override fun setFavoriteCard(isFavoriteCard: Boolean, cardId: Long) {
        viewModel.setFavoriteCard(isFavoriteCard, cardId)
    }
}