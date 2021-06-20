package com.magdalena.cardcollection.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.magdalena.cardcollection.R
import com.magdalena.cardcollection.database.Card

class CardAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: MutableList<Item> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_header, parent, false)
                return HeaderViewHolder(view)
            }
            TYPE_CARD_ITEM -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card, parent, false)
                return CardViewHolder(view)
            }
            else -> {
                throw  RuntimeException("There is no type that matches the type $viewType. Make sure you are using view types correctly!")

            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            TYPE_HEADER ->{
                val headerItem = items[position] as HeaderItem
                val headerHolder = holder as HeaderViewHolder
                headerHolder.itemView.apply {

                }
            }
            TYPE_CARD_ITEM ->{
                val cardItem = items[position] as CardItem
                val cardViewHolder = holder as CardViewHolder
                cardViewHolder.itemView.apply {

                }
            }
        }
    }

    override fun getItemCount(): Int = items.size


    fun listCategory(cardItems: MutableList<Item>) {
        items.addAll(cardItems)
        notifyDataSetChanged()
    }


    fun groupCategory(groupSection: Map<String, List<Card>>){
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

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    fun clearList() {
        items.clear()
    }

    companion object {
        private const val TYPE_HEADER = 1
        private const val TYPE_CARD_ITEM = 2
    }

}