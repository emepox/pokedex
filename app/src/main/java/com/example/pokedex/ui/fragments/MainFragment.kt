package com.example.pokedex.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.data.models.apiEntityModels.PokemonModel
import com.example.pokedex.databinding.FragmentMainBinding
import com.example.pokedex.mediators.PokemonViewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    lateinit var binding: FragmentMainBinding
    lateinit var currentPokemon: PokemonModel
    private val pokemonViewModel by viewModels<PokemonViewModel>()
    private var menu: Menu? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Binding
        binding = FragmentMainBinding.bind(view)

        // INITIALISE THE CALL to the Pokemon API
        // Check if there are arguments passed from search
        if(arguments == null) {
            getRandomPokemon()
        } else {
            arguments?.getString("search")?.let {
                pokemonViewModel.getPokemon(it)
                pokemonViewModel.isPokemonAFavouriteByName(it)
            }
            arguments = null
        }

        // Call the observers
        pokemonObserver()
        favsCheckerObserver()
        // Set menu
        setHasOptionsMenu(true)

        // Listeners
        with(binding){
            btnRandom.setOnClickListener {getRandomPokemon()}
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        this.menu = menu
        inflater.inflate(R.menu.fav_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.like_icon) {
            Log.e("Menu", "$id")
            pokemonViewModel.addPokemonToFavourites(currentPokemon)
            Toast.makeText(requireContext(), "Added to favourites", Toast.LENGTH_SHORT).show()
            return true
        }
        /*
        if (id == R.id.mainFragment) {
            Log.e("Menu", "$id")
            Toast.makeText(requireContext(), "AAAA", Toast.LENGTH_SHORT).show()
            return true
        }

         */

        return super.onOptionsItemSelected(item)
    }

    private fun pokemonObserver() {
        pokemonViewModel.response.observe(viewLifecycleOwner) { pokemon ->
            if(pokemon == null) {
                Toast.makeText(requireContext(), "Please add a new Pok??mon", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.errorFragment)
                return@observe
            }

            currentPokemon = pokemon
            val heightM = pokemon.height.toBigDecimal().divide(10.toBigDecimal())
            val weightM = pokemon.weight.toBigDecimal().divide(10.toBigDecimal())

            with(binding) {
                tvMainPokemonName.text = (pokemon.name).uppercase()
                tvMainPokemonNumber.text = "#${pokemon.id}"
                tvMainPokemonHeight.text = "Height: ${heightM}m"
                tvMainPokemonWeight.text = "Weight: ${weightM}kg"
                // Image
                Glide.with(requireContext())
                    .load(pokemon.sprites.other.officialArtwork.front_default)
                    .dontAnimate()
                    .into(ivMainPokemonImage)
            }
        }
    }

    private fun favsCheckerObserver() {
        pokemonViewModel.checker.observe(viewLifecycleOwner) {
            if(it) {
                menu?.findItem(R.id.like_icon)?.setIcon(R.drawable.ic_heart_full)
            }
        }
    }

    fun getRandomPokemon() {
        val random = (1..898).random()
        pokemonViewModel.getPokemon(random.toString())
        pokemonViewModel.isPokemonAFavouriteById(random)
    }


}