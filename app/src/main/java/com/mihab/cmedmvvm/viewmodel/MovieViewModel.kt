package com.mihab.cmedmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mihab.cmedmvvm.service.model.Movie
import com.mihab.cmedmvvm.service.repository.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private var movieLiveData = MutableLiveData<List<Movie>>()

    fun getMovies() {
        ApiClient.RetrofitInstance.api.getPopularMovies().enqueue(object : Callback<List<Movie>> {

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if (response.body() != null) {
                    movieLiveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Log.d("MovieViewModel", t.message.toString())
            }

        })
    }

    fun observeMovieLiveData(): LiveData<List<Movie>> {
        return movieLiveData
    }

}