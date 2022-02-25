package com.example.pokedex.mediators

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.models.apiEntityModels.PokemonModel
import com.example.pokedex.data.repositories.ApiRequestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val apiRepo = ApiRequestRepository()
    val response = MutableLiveData<PokemonModel?>()

    // HTTP CALLS

    // By name
    fun getPokemon(nameOrNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = apiRepo.getData(nameOrNumber)
            response.postValue(result)
        }
    }

}

