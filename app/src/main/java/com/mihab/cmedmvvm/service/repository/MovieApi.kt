package com.mihab.cmedmvvm.service.repository

import com.mihab.cmedmvvm.service.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("api/characters")
    fun getPopularMovies() : Call<List<Movie>>

}