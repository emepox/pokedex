package com.example.pokedex.data.repositories

import android.util.Log
import com.example.pokedex.data.models.ApiService
import com.example.pokedex.data.models.PokemonModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRequestRepository {
    private val BASE_URL = "https://pokeapi.co/api/v2/"
    private val service: ApiService = createRetrofit().create(ApiService::class.java)

    // Retrofit function
    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // FUNCTIONS TO GET THE DATA

    // By name
    fun getDataByName(name: String) : PokemonModel? {
        val response = service.getItemByName(name).execute()
        if(response.isSuccessful) {
            return response.body()!!
        } else {
            Log.e("HTTP Error Tag", "${response.errorBody()}")
            return null
        }
    }

    // By ID
    fun getDataById(id: Int) : PokemonModel? {
        val response = service.getItemByNumber(id).execute()
        if(response.isSuccessful) {
            return response.body()!!
        } else {
            Log.e("HTTP Error Tag", "${response.errorBody()}")
            return null
        }
    }



}
