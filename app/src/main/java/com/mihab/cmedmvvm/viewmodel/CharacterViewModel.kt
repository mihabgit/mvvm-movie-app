package com.mihab.cmedmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mihab.cmedmvvm.service.model.Character
import com.mihab.cmedmvvm.service.repository.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {

    private var characterLiveData = MutableLiveData<List<Character>>()

    fun getMovies() {
        ApiClient.RetrofitInstance.api.getPopularMovies().enqueue(object : Callback<List<Character>> {

            override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>) {
                if (response.body() != null) {
                    characterLiveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                Log.d("MovieViewModel", t.message.toString())
            }

        })
    }

    fun observeMovieLiveData(): LiveData<List<Character>> {
        return characterLiveData
    }

}