package com.example.mvvmstudy.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmstudy.data.remote.characterDTO.CharacterResponseDTO
import com.example.mvvmstudy.data.remote.service.CharacterService

class MainViewModel(private val service: CharacterService) : ViewModel() {

    private val _characters = MutableLiveData<List<CharacterResponseDTO>>()
    val characters: LiveData<List<CharacterResponseDTO>> get() = _characters

    fun loadCharacters() {
        service.getCharacters { characters ->
            Log.i("MainViewModel", "Characters")
            _characters.value = listOf(characters)
        }
    }

}