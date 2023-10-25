package com.mihab.cmedmvvm.service.repository

import com.mihab.cmedmvvm.service.model.Character
import retrofit2.Call
import retrofit2.http.GET

interface CharacterApi {

    @GET("api/characters")
    fun getPopularMovies() : Call<List<Character>>

}