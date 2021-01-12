package com.rsms.mtgmanager.views.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rsms.mtgmanager.R
import com.rsms.mtgmanager.domain.Card
import com.rsms.mtgmanager.domain.Set
import com.rsms.mtgmanager.repositories.network.services.MTGService
import com.rsms.mtgmanager.views.adapters.CardsAdapter
import com.rsms.mtgmanager.views.adapters.SetsAdapter
import kotlinx.coroutines.launch

class CardsActivity : AppCompatActivity() {
//    lateinit var cards: ArrayList<Card>
//
//    private lateinit var mtgService: MTGService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

//        this.mtgService = MTGService(this)
//        val rvCards = findViewById<View>(R.id.rvCards) as RecyclerView
//
//        lifecycleScope.launch() {
//            val result = mtgService.getCards() as ArrayList<Card>
//            cards = result
//            onResult(cards, rvCards)
//        }
    }

//    private fun onResult(cardList: ArrayList<Card>, recyclerView: RecyclerView) {
//        val cardsAdapter = CardsAdapter(this.applicationContext, cardList)
//        recyclerView.adapter = cardsAdapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
//    }
}