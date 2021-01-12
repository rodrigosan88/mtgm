package com.rsms.mtgmanager.repositories.network.services

import android.content.Context
import com.rsms.mtgmanager.domain.Card
import com.rsms.mtgmanager.domain.Set
import com.rsms.mtgmanager.repositories.network.clients.MTGRestClient
import com.rsms.mtgmanager.repositories.network.connectors.MTGApiConnector
import com.rsms.mtgmanager.repositories.network.dtos.SetListDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MTGService (private val context: Context) {

    private val connector = MTGApiConnector().createConnector()

    suspend fun getSets(): List<Set> {
        val service = connector.create(MTGRestClient::class.java)

        return withContext(Dispatchers.IO) {
            val result: SetListDTO = service.setsAsync()

            val resultConverted = result.sets.map { dto ->
                Set(
                    code = dto.code,
                    name = dto.name,
                    type = dto.type,
                    releaseDate = dto.releaseDate,
                    magicCardsInfoCode = dto.magicCardsInfoCode,
                    block = dto.block
                )
            }

            resultConverted
        }
    }

    suspend fun getCards(): List<Card> {
        val service = connector.create(MTGRestClient::class.java)

        return withContext(Dispatchers.IO) {
            val result = service.cardsAsync()

            val resultConverted = result.cards.map {dto ->
                Card(
                    name = dto.name,
                    manaCost = dto.manaCost,
                    cmc = dto.cmc,
                    colors = dto.colors,
                    colorIdentity = dto.colorIdentity,
                    type = dto.type,
                    types = dto.types,
                    subtypes = dto.subtypes
                )
            }

            resultConverted
        }
    }

}