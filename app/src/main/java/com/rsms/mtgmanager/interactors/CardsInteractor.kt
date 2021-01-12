package com.rsms.mtgmanager.interactors

import android.content.Context
import com.rsms.mtgmanager.domain.Card
import com.rsms.mtgmanager.domain.Set
import com.rsms.mtgmanager.repositories.network.services.MTGService

class CardsInteractor(private val context: Context) {
    private val mtgService = MTGService(context)

    suspend fun recoverCards() : ArrayList<Card>{
        return this.mtgService.getCards() as ArrayList<Card>
    }
}