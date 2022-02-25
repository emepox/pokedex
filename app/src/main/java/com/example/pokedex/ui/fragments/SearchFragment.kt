package com.example.pokedex.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.pokedex.R
import com.example.pokedex.data.models.PokemonModel
import com.example.pokedex.databinding.FragmentFavouritesBinding
import com.example.pokedex.databinding.FragmentSearchBinding
import com.example.pokedex.mediators.PokemonViewModel

class SearchFragment : Fragment(R.layout.fragment_search) {
    private lateinit var binding: FragmentSearchBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSearchBinding.bind(view)

        with(binding) {
            btnSearch.setOnClickListener {
                val search = etSearch.text.toString()
                if(search.isEmpty()) {
                    Toast.makeText(requireContext(), "Please add a name or a number", Toast.LENGTH_SHORT).show()
                } else {
                    findNavController().navigate(R.id.action_searchFragment_to_mainFragment,
                        Bundle().apply {
                            putString("search", search)
                        }
                    )
                }
            }
        }
    }
}