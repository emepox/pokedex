package com.example.pokedex.mediators

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.models.apiEntityModels.PokemonModel
import com.example.pokedex.data.repositories.FavouritesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouritesViewModel(application: Application) : AndroidViewModel(application) {

    private val favsRepo = FavouritesRepository(application)
    val response = MutableLiveData<MutableList<PokemonModel>>()

    // ACTIONS

    // Get all Pokemon
    fun getAllFavouritePokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = favsRepo.getAllData()
            response.postValue(result)
        }
    }

}