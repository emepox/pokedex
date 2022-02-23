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

    // Instead of having two requests, will this work? We will see
    @GET("pokemon/{pokemonName}{pokemonNumber}")
    fun getItem(@Path("pokemonName") pokemonName : String, @Path("pokemonNumber") pokemonNumber: Int) : Call<PokemonModel>


}