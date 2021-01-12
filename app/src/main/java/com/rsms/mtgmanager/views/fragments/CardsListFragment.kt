package com.rsms.mtgmanager.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.domain.Card
import com.rsms.mtgmanager.repositories.network.services.MTGService
import com.rsms.mtgmanager.views.adapters.CardsAdapter
import kotlinx.android.synthetic.main.fragment_cards_list.*
import kotlinx.coroutines.launch

class CardsListFragment : Fragment() {

    lateinit var cards: ArrayList<Card>

    private lateinit var mtgService: MTGService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cards_list, container, false)

        this.mtgService = MTGService(requireContext())

        lifecycleScope.launch() {
            val result = mtgService.getCards() as ArrayList<Card>
            cards = result
            onResult(cards)
        }

        return view
    }

    private fun onResult(cardList: ArrayList<Card>) {
        val cardsAdapter = CardsAdapter(requireContext().applicationContext, cardList)
        rvCards.adapter = cardsAdapter
        rvCards.layoutManager = LinearLayoutManager(requireContext())
    }

}