package com.example.mvvmstudy.data.remote.service

import android.util.Log
import com.example.mvvmstudy.data.remote.CharacterRepository
import com.example.mvvmstudy.data.remote.characterDTO.CharacterDTO
import com.example.mvvmstudy.data.remote.characterDTO.CharacterResponseDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterService(private val repository: CharacterRepository) {
    fun getCharacters(onResult: (CharacterResponseDTO) -> Unit) =
        repository.getCharacters().enqueue(object : Callback<CharacterResponseDTO> {
            override fun onResponse(
                call: Call<CharacterResponseDTO>,
                response: Response<CharacterResponseDTO>
            ) {
                if (response.isSuccessful) {
                    Log.e("CharacterService", "Success")
                    onResult(response.body()!!)
                }
            }

            override fun onFailure(call: Call<CharacterResponseDTO>, t: Throwable) {
                Log.e("CharacterService", "Error: ${t.message}")
            }
        })
}