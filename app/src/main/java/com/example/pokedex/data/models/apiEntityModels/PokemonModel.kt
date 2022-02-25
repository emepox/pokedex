package com.example.pokedex.data.models.apiEntityModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedex.data.models.apiEntityModels.SpritesModel

@Entity
data class PokemonModel(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "height") val height: String,
    @ColumnInfo(name = "weight") val weight: String,
    @ColumnInfo(name = "image") val sprites: SpritesModel

    )
