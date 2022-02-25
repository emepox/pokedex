package com.example.pokedex.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.data.models.FavouritesRecyclerAdapter
import com.example.pokedex.databinding.FragmentFavouritesBinding
import com.example.pokedex.mediators.FavouritesViewModel

class FavouritesFragment : Fragment(R.layout.fragment_favourites) {

    private lateinit var binding: FragmentFavouritesBinding
    private val favsViewModel by viewModels<FavouritesViewModel>()

    private lateinit var recyclerView : RecyclerView
    private lateinit var myAdapter: FavouritesRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Binding
        binding = FragmentFavouritesBinding.bind(view)
        recyclerView = binding.rvFav
        // Call the room
        favsViewModel.getAllFavouritePokemon()
        // Observe
        favouritesObserver()
    }

    // Observer
    fun favouritesObserver() {
        favsViewModel.response.observe(viewLifecycleOwner) {resultFavs ->
            myAdapter = FavouritesRecyclerAdapter(resultFavs)
            recyclerView.adapter = myAdapter
            recyclerView.layoutManager = GridLayoutManager(view?.context, 2)
        }
    }

}