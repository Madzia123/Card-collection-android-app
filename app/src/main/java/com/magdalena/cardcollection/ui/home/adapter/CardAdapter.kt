package com.magdalena.cardcollection.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.inverce.mod.v2.core.context
import com.magdalena.cardcollection.R
import com.magdalena.cardcollection.database.Card
import com.magdalena.cardcollection.databinding.ItemCardBinding
import com.magdalena.cardcollection.databinding.ItemHeaderBinding
import com.magdalena.cardcollection.ui.home.HomeFragment
import java.lang.ref.WeakReference

class CardAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: MutableList<Item> = mutableListOf()

    var listener: WeakReference<CardListener>? = null

    fun setListener(listener: CardListener) {
        this.listener = WeakReference(listener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> {
                val binding =
                    ItemHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                HeaderViewHolder(binding)
            }
            TYPE_CARD_ITEM -> {
                val binding =
                    ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CardViewHolder(binding)
            }
            else -> {
                throw  RuntimeException("There is no type that matches the type $viewType. Make sure you are using view types correctly!")

            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            TYPE_HEADER -> {
                val headerItem = items[position] as HeaderItem
                val headerHolder = holder as HeaderViewHolder
                headerHolder.binding.apply {

                }

            }
            TYPE_CARD_ITEM -> {
                val cardItem = items[position] as CardItem
                val cardViewHolder = holder as CardViewHolder
                cardViewHolder.binding.apply {
                    val isFavoriteCard = !cardItem.card.isFavorite

                    Glide.with(context)
                        .load(cardItem.card.image)
                        .into(cardImage)

                    favoriteCard.setBackgroundResource(if (isFavoriteCard) R.drawable.ic_favorite else R.drawable.ic_un_favorite)

                    cardNumber.text = cardItem.card.numberCard
                    favoriteCard.setOnClickListener {
                        listener?.get()?.setFavoriteCard(isFavoriteCard, cardItem.card.id)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size


    fun listCategory(cardItems: MutableList<Item>) {
        items.addAll(cardItems)
        notifyDataSetChanged()
    }


    fun groupCategory(groupSection: Map<String, List<Card>>) {
        for (header in groupSection.keys) {
            val headerItem = HeaderItem(header)
            items.add(headerItem)
            for (item in groupSection[header]!!) {
                val generalItem = CardItem(item)
                items.add(generalItem)
            }
        }
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is HeaderItem -> TYPE_HEADER
            is CardItem -> TYPE_CARD_ITEM
        }
    }

    inner class HeaderViewHolder(val binding: ItemHeaderBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class CardViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root)


    fun clearList() {
        items.clear()
    }

    companion object {
        private const val TYPE_HEADER = 1
        private const val TYPE_CARD_ITEM = 2
    }

}