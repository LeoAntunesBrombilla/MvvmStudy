package com.example.mvvmstudy.data.remote

import com.example.mvvmstudy.data.remote.characterDTO.CharacterResponseDTO
import retrofit2.http.GET

interface ICharacterRepository {

    @GET("/people")
    fun getCharacters(): List<CharacterResponseDTO>
}