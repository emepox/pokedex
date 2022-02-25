package com.example.pokedex.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavouritesModel(
    @PrimaryKey val id: Int,
    )
