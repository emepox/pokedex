package com.example.pokedex.data.models

import androidx.room.TypeConverter
import com.google.gson.Gson

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