package com.rsms.mtgmanager.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.domain.Card

class CardsAdapter(val context: Context, private val cards: List<Card>) :
    RecyclerView.Adapter<CardsAdapter.CardsViewHolder>() {

    class CardsViewHolder(val listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val cardName = listItemView.findViewById<TextView>(R.id.cardName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val inflater = LayoutInflater.from(this.context)

        val cardsView = inflater.inflate(R.layout.card_item, parent, false)

        return CardsViewHolder(cardsView)
    }

    override fun onBindViewHolder(viewHolder: CardsAdapter.CardsViewHolder, position: Int) {
        val card: Card = cards[position]
        viewHolder.cardName.text = card.name
    }

    override fun getItemCount(): Int {
        return cards.size
    }
}