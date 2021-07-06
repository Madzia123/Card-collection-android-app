package com.magdalena.cardcollection.ui.addCard

import android.content.Intent
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider

import com.magdalena.cardcollection.R
import com.magdalena.cardcollection.database.Card
import com.magdalena.cardcollection.databinding.FragmentAddCardBinding
import com.magdalena.cardcollection.ui.base.BaseFragment
import com.magdalena.cardcollection.utils.value


class AddCardFragment : BaseFragment() {

    private var _binding: FragmentAddCardBinding? = null
    private lateinit var viewModel: AddCardViewModel

    private var isFavoriteCard = false

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(AddCardViewModel::class.java)
        _binding = FragmentAddCardBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.setFavoriteCard.setOnClickListener {
            isFavoriteCard = !isFavoriteCard
            binding.cardFavorite.setImageResource(if (isFavoriteCard) R.drawable.ic_favorite else R.drawable.ic_un_favorite)
        }

        binding.addCardButton.setOnClickListener {

            val numberCard = binding.numberCardInput.value


        }
    }


    override fun onResume() {
        super.onResume()
        toolbarTitle = getString(R.string.add_card)
    }

}