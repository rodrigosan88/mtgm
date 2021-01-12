package com.rsms.mtgmanager.repositories.network.dtos

import com.google.gson.annotations.SerializedName
import java.util.*

data class SetDTO(
    val code: String,
    val name: String,
    val type: String,
    val border: String,
    @SerializedName("mkm_id")
    val mkmId: Int,
    @SerializedName("mkm_name")
    val mkmName: String,
    val releaseDate: Date,
    val magicCardsInfoCode: String,
    val block: String
    )