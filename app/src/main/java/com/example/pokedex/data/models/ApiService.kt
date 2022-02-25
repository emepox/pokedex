package com.example.pokedex.data.models

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call


interface ApiService {

    // The endpoint accepts either:

    // Strings...
    @GET("pokemon/{nameOrNumber}")
    fun getItem(@Path("nameOrNumber") nameOrNumber : String) : Call<PokemonModel>

}