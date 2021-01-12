package com.rsms.mtgmanager.repositories.network.dtos

data class CardDTO(val name: String,
                val manaCost: String,
                val cmc: Int,
                val colors: List<String>,
                val colorIdentity: List<String>,
                val type: String,
                val types: List<String>,
                val subtypes: List<String>,
                val imageUrl: String, val text: String?
)