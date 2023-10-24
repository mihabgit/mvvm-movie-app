package com.mihab.cmedmvvm.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL

import com.mihab.cmedmvvm.databinding.ActivityMainBinding
import com.mihab.cmedmvvm.view.adapter.MovieAdapter
import com.mihab.cmedmvvm.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        initiateRecyclerView()

        movieViewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        movieViewModel.getMovies()
        movieViewModel.observeMovieLiveData().observe(this) { movieList ->
            movieAdapter.setMovieList(movieList)
        }


    }

    private fun initiateRecyclerView() {
        movieAdapter = MovieAdapter()
        binding.rvMovies.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, VERTICAL, false)
            adapter = movieAdapter
        }
    }

}