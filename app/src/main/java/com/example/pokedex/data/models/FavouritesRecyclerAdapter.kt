package com.example.pokedex.data.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.data.models.apiEntityModels.PokemonModel
import com.example.pokedex.databinding.ItemFavBinding

class FavouritesRecyclerAdapter(private val dataSet: MutableList<PokemonModel>) :
    RecyclerView.Adapter<FavouritesRecyclerAdapter.MyViewHolder>()
{
        class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            private val binding = ItemFavBinding.bind(view)

            val favImage = binding.ivFavItem
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fav, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentData: PokemonModel = dataSet.get(position)

        Glide.with(holder.favImage.context).load(currentData.sprites.other.officialArtwork.front_default).into(holder.favImage)    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}