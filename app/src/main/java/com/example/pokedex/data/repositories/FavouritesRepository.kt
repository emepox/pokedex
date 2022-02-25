package com.example.pokedex.data.repositories

import android.content.Context
import com.example.pokedex.data.databases.DatabaseSingleton
import com.example.pokedex.data.models.apiEntityModels.PokemonModel

class FavouritesRepository(val context: Context) {

    fun storeData(pokemon: PokemonModel) {
        DatabaseSingleton.getInstance(context).favouritesDao().insertFav(pokemon)
    }

    fun getAllData(): MutableList<PokemonModel> {
        return DatabaseSingleton.getInstance(context).favouritesDao().getAll()
    }

    fun getAnItem(id: Int): PokemonModel {
        return DatabaseSingleton.getInstance(context).favouritesDao().getOneById(id)
    }

    fun existsCheckerById(id: Int): Boolean {
        return DatabaseSingleton.getInstance(context).favouritesDao().existsById(id)
    }

    fun existsCheckerByName(name: String): Boolean {
        return DatabaseSingleton.getInstance(context).favouritesDao().existsByName(name)
    }

    fun deleteItem(pokemon: PokemonModel) {
        return DatabaseSingleton.getInstance(context).favouritesDao().delete(pokemon)
    }
}