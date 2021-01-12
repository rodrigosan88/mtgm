package com.rsms.mtgmanager.domain

data class Card(val name: String?,
                val manaCost: String?,
                val cmc: Int?,
                val colors: List<String>?,
                val colorIdentity: List<String>?,
                val type: String?,
                val types: List<String>?,
                val subtypes: List<String>?)