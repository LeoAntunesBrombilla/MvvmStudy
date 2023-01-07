package com.example.mvvmstudy.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmstudy.data.remote.service.CharacterService

class MainViewModelFactory(private val service: CharacterService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(service) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
