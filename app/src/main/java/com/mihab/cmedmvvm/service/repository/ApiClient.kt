package com.mihab.cmedmvvm.service.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {

    object RetrofitInstance {

        private const val BASE_URL = "https://hp-api.onrender.com/"

        val api : MovieApi by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieApi::class.java)
        }

    }

}