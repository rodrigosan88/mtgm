package com.rsms.mtgmanager.domain

import java.io.Serializable

data class Card(val name: String?,
                val manaCost: String?,
                val cmc: Int?,
                val colors: List<String>?,
                val colorIdentity: List<String>?,
                val type: String?,
                val types: List<String>?,
                val subtypes: List<String>?,
                val imageUrl: String?,
                val text: String?
): Serializable