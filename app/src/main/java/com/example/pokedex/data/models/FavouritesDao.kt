package com.example.pokedex.data.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.pokedex.data.models.apiEntityModels.PokemonModel

@Dao
interface FavouritesDao {
    @Query("SELECT * FROM PokemonModel")
    fun getAll(): MutableList<PokemonModel>

    @Query("SELECT * FROM PokemonModel WHERE id LIKE (:id)")
    fun getOneById(id: Int) : PokemonModel

    @Query("SELECT EXISTS (SELECT * FROM PokemonModel WHERE id = :id)")
    fun exists(id: Int): Boolean

    @Insert
    fun insertFav(pokemon: PokemonModel)

    @Delete
    fun delete(pokemon: PokemonModel)
}