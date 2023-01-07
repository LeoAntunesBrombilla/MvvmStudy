package com.example.mvvmstudy.data.remote

import com.example.mvvmstudy.data.remote.characterDTO.CharacterResponseDTO
import retrofit2.Call

class CharacterRepository(private val retrofitClient: RetrofitClient) : ICharacterRepository {


    override fun getCharacters(): Call<CharacterResponseDTO> {
        return retrofitClient.getCharacterApi().getCharacters()
    }

}