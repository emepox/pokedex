package com.example.pokedex.data.models

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call


interface ApiService {

    // The endpoint accepts either:

    // Strings...
    @GET("pokemon/{pokemonName}")
    fun getItemByName(@Path("pokemonName") pokemonName : String) : Call<PokemonModel>

    //...or Integers
    @GET("pokemon/{pokemonNumber}")
    fun getItemByNumber(@Path("pokemonNumber") pokemonNumber : Int) : Call<PokemonModel>


}