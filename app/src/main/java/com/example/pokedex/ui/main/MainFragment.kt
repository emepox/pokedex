package com.example.pokedex.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentMainBinding
import com.example.pokedex.mediators.PokemonViewModel
import java.util.*

class MainFragment : Fragment(R.layout.fragment_main) {

    lateinit var binding: FragmentMainBinding
    private val pokemonViewModel by viewModels<PokemonViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Binding
        binding = FragmentMainBinding.bind(view)
        // Initialise the call to the Pokemon API
        pokemonViewModel.getPokemonById((1..898).random())
        // Call the observer
        pokemonObserver()

    }
    private fun pokemonObserver() {
        pokemonViewModel.response.observe(viewLifecycleOwner) { pokemon ->
            if(pokemon == null) {
                Toast.makeText(requireContext(), "THIS REQUEST WAS NULL", Toast.LENGTH_SHORT).show()
                return@observe
            }
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