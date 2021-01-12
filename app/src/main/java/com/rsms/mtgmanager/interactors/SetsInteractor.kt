package com.rsms.mtgmanager.interactors

import android.content.Context
import com.rsms.mtgmanager.domain.Set
import com.rsms.mtgmanager.repositories.network.services.MTGService

class SetsInteractor(private val context: Context) {

    private val mtgService = MTGService(context)

    suspend fun recoverSets() : ArrayList<Set>{
        return this.mtgService.getSets() as ArrayList<Set>
    }
}