package com.example.mvvmstudy.data.remote.service

import android.util.Log
import com.example.mvvmstudy.data.remote.CharacterRepository
import com.example.mvvmstudy.data.remote.characterDTO.CharacterResponseDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterService(private val repository: CharacterRepository) {

    fun getCharacters(onResult: (List<CharacterResponseDTO>) -> Unit) =
        repository.getCharacters().enqueue(object : Callback<List<CharacterResponseDTO>> {
            override fun onResponse(
                call: Call<List<CharacterResponseDTO>>,
                response: Response<List<CharacterResponseDTO>>
            ) {
                if (response.isSuccessful) {
                    onResult(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<CharacterResponseDTO>>, t: Throwable) {
                Log.e("CharacterService", "Error: ${t.message}")
            }
        })
}