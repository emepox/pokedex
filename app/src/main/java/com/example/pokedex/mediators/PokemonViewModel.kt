package com.example.pokedex.mediators

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.models.apiEntityModels.PokemonModel
import com.example.pokedex.data.repositories.ApiRequestRepository
import com.example.pokedex.data.repositories.FavouritesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(application: Application) : AndroidViewModel(application) {

    private val apiRepo = ApiRequestRepository()
    private val favsRepo = FavouritesRepository(application)
    val response = MutableLiveData<PokemonModel?>()
    val checker = MutableLiveData<Boolean>()

    // HTTP CALLS

    fun getPokemon(nameOrNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = apiRepo.getData(nameOrNumber)
            response.postValue(result)
        }
    }

    // Check if Pokémon is favourite
    fun isPokemonAFavouriteById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = favsRepo.existsCheckerById(id)
            checker.postValue(result)
        }
    }

    fun isPokemonAFavouriteByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = favsRepo.existsCheckerByName(name)
            checker.postValue(result)
        }
    }

    // Add pokemon in favourites
    fun addPokemonToFavourites(pokemon: PokemonModel) {
        viewModelScope.launch(Dispatchers.IO) {
            favsRepo.storeData(pokemon)
        }
    }

    // Delete a favourite
    fun deleteAFavouritePokemon(pokemon: PokemonModel) {
        viewModelScope.launch(Dispatchers.IO) {
            favsRepo.deleteItem(pokemon)
        }
    }

}

