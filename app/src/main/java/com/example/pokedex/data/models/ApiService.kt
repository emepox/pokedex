package com.example.pokedex.data.models

import com.example.pokedex.data.models.apiEntityModels.PokemonModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call


interface ApiService {
    @GET("pokemon/{nameOrNumber}")
    fun getItem(@Path("nameOrNumber") nameOrNumber : String) : Call<PokemonModel>
}