package com.example.pokedex.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentMainBinding
import com.example.pokedex.mediators.PokemonViewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    lateinit var binding: FragmentMainBinding
    private val pokemonViewModel by viewModels<PokemonViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialise Binding
        binding = FragmentMainBinding.bind(view)

        // Initialise the call to the Pokemon API
        pokemonViewModel.getPokemonById((1..1126).random())
        // Call the observer
        pokemonObserver()
    }

    fun pokemonObserver() {
        pokemonViewModel.response.observe(viewLifecycleOwner) { pokemon ->
            with(binding) {
                tvMainPokemonName.text = pokemon.name
                tvMainPokemonNumber.text = pokemon.id.toString()
                tvMainPokemonHeight.text = pokemon.height
                tvMainPokemonWeight.text = pokemon.weight
                // Image
                /*
                Glide.with(requireContext())
                    .load(pokemon.other.officialArtwork.front_default)
                    .dontAnimate()
                    .into(ivMainPokemonImage)

                 */
            }
        }
    }

}