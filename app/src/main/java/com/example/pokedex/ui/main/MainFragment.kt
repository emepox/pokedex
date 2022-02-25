package com.example.pokedex.ui.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.data.models.PokemonModel
import com.example.pokedex.databinding.FragmentMainBinding
import com.example.pokedex.mediators.FavouritesViewModel
import com.example.pokedex.mediators.PokemonViewModel
import java.util.*

class MainFragment : Fragment(R.layout.fragment_main) {

    lateinit var binding: FragmentMainBinding
    lateinit var currentPokemon: PokemonModel
    private val pokemonViewModel by viewModels<PokemonViewModel>()
    private val favsViewModel by viewModels<FavouritesViewModel>()
    private var menu: Menu? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Binding
        binding = FragmentMainBinding.bind(view)
        // Initialise the call to the Pokemon API
        pokemonViewModel.getPokemonById((1..898).random())
        // Call the observer
        pokemonObserver()
        setHasOptionsMenu(true)

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        this.menu = menu
        inflater.inflate(R.menu.fav_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()
        if (id == R.id.like_icon) {
            favsViewModel.addPokemonToFavourites(currentPokemon)
            Toast.makeText(requireContext(), "CLICKED", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun pokemonObserver() {
        pokemonViewModel.response.observe(viewLifecycleOwner) { pokemon ->
            if(pokemon == null) {
                Toast.makeText(requireContext(), "THIS REQUEST WAS NULL", Toast.LENGTH_SHORT).show()
                return@observe
            }
            currentPokemon = pokemon
            with(binding) {
                tvMainPokemonName.text = (pokemon.name).uppercase()
                tvMainPokemonNumber.text = "Number: ${pokemon.id.toString()}"
                tvMainPokemonHeight.text = "Height: ${pokemon.height}"
                tvMainPokemonWeight.text = "Weight: ${pokemon.weight}"
                // Image
                Glide.with(requireContext())
                    .load(pokemon.sprites.other.officialArtwork.front_default)
                    .dontAnimate()
                    .into(ivMainPokemonImage)
            }
        }
    }


}