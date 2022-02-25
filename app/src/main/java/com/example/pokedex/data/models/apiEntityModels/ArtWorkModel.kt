package com.example.pokedex.data.models.apiEntityModels

import com.example.pokedex.data.models.apiEntityModels.OfficialArtworkModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ArtWorkModel(
    @SerializedName("official-artwork")
    @Expose
    val officialArtwork: OfficialArtworkModel
    )
