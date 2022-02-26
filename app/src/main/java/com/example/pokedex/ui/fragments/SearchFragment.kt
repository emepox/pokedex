package com.example.pokedex.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentSearchBinding
import java.util.*

class SearchFragment : Fragment(R.layout.fragment_search) {
    private lateinit var binding: FragmentSearchBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSearchBinding.bind(view)

        with(binding) {
            btnSearch.setOnClickListener {
                if(etSearch.text.isEmpty()) {
                    Toast.makeText(requireContext(), "Please add a name or a number", Toast.LENGTH_SHORT).show()
                } else if (etSearch.text.length > 20){
                    Toast.makeText(requireContext(), "Please add a shorter name or number", Toast.LENGTH_SHORT).show()
                } else {
                    val search = etSearch.text.toString().lowercase()
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