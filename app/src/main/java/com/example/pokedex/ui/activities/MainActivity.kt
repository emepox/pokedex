package com.example.pokedex.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pokedex.R
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.mediators.FavouritesViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        binding.navView.setupWithNavController(navController)
    }

    /*
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.like_icon) {
            currentComic?.let {
                CoroutineScope(Dispatchers.IO).launch {
                    if (favoritesRepository.isComicFavorite(it)) {
                        favoritesRepository.removeComicAsFavorite(it)
                    } else {
                        favoritesRepository.addComicAsFavorite(it)
                    }

                    withContext(Dispatchers.Main) {
                        setLikeIcon(it)
                    }
                }
            }
        }

        return true
    }


   ------


       private fun setLikeIcon(comic: ComicResponse) {
        CoroutineScope(Dispatchers.IO).launch {
            val isFavorite = favoritesRepository.isComicFavorite(comic)

            withContext(Dispatchers.Main) {
                menu?.findItem(R.id.like_icon)?.setIcon(
                    if (isFavorite)
                        R.drawable.ic_favorite
                    else
                        R.drawable.ic_favorite_border
                )
            }
        }
    }


     */

}
