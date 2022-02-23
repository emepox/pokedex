package com.example.pokedex.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ArtWorkModel(
    @SerializedName("official-artwork")
    @Expose
    val officialArtwork: OfficialArtworkModel
    )
