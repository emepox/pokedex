package com.example.pokedex.data.models

import androidx.room.TypeConverter
import com.example.pokedex.data.models.apiEntityModels.ArtWorkModel
import com.example.pokedex.data.models.apiEntityModels.OfficialArtworkModel
import com.example.pokedex.data.models.apiEntityModels.SpritesModel

class ImageConverter {

    @TypeConverter
    fun fromImage(image: String): SpritesModel? {
        return SpritesModel(ArtWorkModel(OfficialArtworkModel(image)))
    }

    @TypeConverter
    fun toImage(sprites: SpritesModel?): String? {
        return sprites?.other?.officialArtwork?.front_default
    }

}