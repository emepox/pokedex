package com.example.pokedex.data.models

import androidx.room.ColumnInfo

data class OfficialArtworkModel(
    @ColumnInfo(name = "image") val front_default: String
)
