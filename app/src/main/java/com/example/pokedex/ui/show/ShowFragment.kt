package com.example.pokedex.ui.show

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentMainBinding
import com.example.pokedex.databinding.FragmentShowBinding
import com.example.pokedex.mediators.PokemonViewModel

class ShowFragment : Fragment(R.layout.fragment_show) {
    lateinit var binding: FragmentShowBinding
    private val pokemonViewModel by viewModels<PokemonViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialise Binding
        binding = FragmentShowBinding.bind(view)

        // Initialise the call to the Pokemon API
        pokemonViewModel.getPokemonById((1..1126).random())
        // Call the observer
        pokemonObserver()
    }

    fun pokemonObserver() {
        pokemonViewModel.response.observe(viewLifecycleOwner) { pokemon ->
            with(binding) {

                tvShowPokemonName.text = pokemon.name
                tvShowPokemonNumber.text = pokemon.id.toString()
                tvShowPokemonHeight.text = pokemon.height
                tvShowPokemonWeight.text = pokemon.weight
                // Image

                Glide.with(requireContext())
                    .load(pokemon.sprites.other.officialArtwork.front_default)
                    .dontAnimate()
                    .into(ivShowPokemonImage)
            }
        }
    }
}