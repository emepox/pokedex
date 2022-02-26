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
    val checker = MutableLiveData<Boolean>()

    // ACTIONS

    // Add pokemon in favourites
    fun addPokemonToFavourites(pokemon: PokemonModel) {
        viewModelScope.launch(Dispatchers.IO) {
            favsRepo.storeData(pokemon)
        }
    }

    // Get all Pokemon
    fun getAllFavouritePokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = favsRepo.getAllData()
            response.postValue(result)
        }
    }

    // Delete a favourite
    fun deleteAFavouritePokemon(pokemon: PokemonModel) {
        viewModelScope.launch(Dispatchers.IO) {
            favsRepo.deleteItem(pokemon)
        }
    }

    // Check if Pokémon is favourite
    fun isPokemonAFavouriteById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = favsRepo.existsCheckerById(id)
            println("HELLO $result")
            checker.postValue(result)
        }
    }

    fun isPokemonAFavouriteByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = favsRepo.existsCheckerByName(name)
            checker.postValue(result)
        }
    }

}