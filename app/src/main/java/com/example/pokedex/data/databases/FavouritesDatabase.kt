package com.example.pokedex.data.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pokedex.data.models.FavouritesDao
import com.example.pokedex.data.models.ImageConverter
import com.example.pokedex.data.models.PokemonModel

@Database(entities = [PokemonModel::class], version = 1)
@TypeConverters(ImageConverter::class)
abstract class FavouritesDatabase : RoomDatabase() {
    abstract fun favouritesDao() : FavouritesDao
}

// Singleton
object DatabaseSingleton {
    private var instance: FavouritesDatabase? = null
    fun getInstance(context: Context): FavouritesDatabase {
        return instance ?: Room.databaseBuilder(context, FavouritesDatabase::class.java, "Favourites").build().also {
            instance = it
        }
    }
}