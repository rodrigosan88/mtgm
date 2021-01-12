package com.rsms.mtgmanager.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class Set(
    val code: String?,
    val name: String?,
    val type: String?,
    val releaseDate: Date?,
    val magicCardsInfoCode: String?,
    val block: String?
): Serializable