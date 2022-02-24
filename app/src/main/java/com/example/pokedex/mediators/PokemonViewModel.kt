package com.example.pokedex.mediators

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.models.PokemonModel
import com.example.pokedex.data.repositories.ApiRequestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val apiRepo = ApiRequestRepository()
    val response = MutableLiveData<PokemonModel?>()


    // HTTP CALLS

    // By name
    fun getPokemonByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = apiRepo.getDataByName(name)
            response.postValue(result)
        }
    }

    // By ID
    fun getPokemonById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = apiRepo.getDataById(id)
            response.postValue(result)
        }
    }
}

