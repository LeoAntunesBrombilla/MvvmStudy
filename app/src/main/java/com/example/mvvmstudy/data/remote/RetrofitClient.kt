package com.example.mvvmstudy.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://swapi.dev/api")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getCharacterApi(): ICharacterRepository {
        return retrofit.create(ICharacterRepository::class.java)
    }
}