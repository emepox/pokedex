package com.example.pokedex.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentErrorBinding


class ErrorFragment : Fragment(R.layout.fragment_error) {

    lateinit var binding : FragmentErrorBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Binding
        binding = FragmentErrorBinding.bind(view)

        with(binding) {
            btnError.setOnClickListener {
                findNavController().navigate(R.id.action_errorFragment_to_searchFragment)
            }
        }

    }

}