package com.example.pokedex.mediators

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.models.apiEntityModels.PokemonModel
import com.example.pokedex.data.repositories.ApiRequestRepository
import com.example.pokedex.data.repositories.FavouritesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val apiRepo = ApiRequestRepository()
    //private val favsRepo = FavouritesRepository()
    val response = MutableLiveData<PokemonModel?>()


    // HTTP CALLS

    fun getPokemon(nameOrNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = apiRepo.getData(nameOrNumber)
            response.postValue(result)
        }
    }

}

