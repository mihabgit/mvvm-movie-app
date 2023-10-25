package com.mihab.cmedmvvm.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL

import com.mihab.cmedmvvm.databinding.ActivityMainBinding
import com.mihab.cmedmvvm.service.model.Character
import com.mihab.cmedmvvm.view.adapter.CharacterAdapter
import com.mihab.cmedmvvm.viewmodel.CharacterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieViewModel: CharacterViewModel
    private lateinit var movieAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        initiateRecyclerView()

        binding.progressCircular.visibility = View.VISIBLE

        movieViewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        movieViewModel.getMovies()
        movieViewModel.observeMovieLiveData().observe(this) { movieList ->
            movieAdapter.setMovieList(movieList)
            binding.progressCircular.visibility = View.GONE
        }


    }

    private fun initiateRecyclerView() {
        movieAdapter = CharacterAdapter()
        binding.rvMovies.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, VERTICAL, false)
            adapter = movieAdapter
        }

        movieAdapter.setOnClickListener(object : CharacterAdapter.OnClickListener {
            override fun onClick(position: Int, movie: Character) {
                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtra("character-details", movie)
                startActivity(intent)
            }
        })

    }

}