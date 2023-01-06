package com.example.mvvmstudy.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmstudy.data.remote.characterDTO.CharacterResponseDTO

class MainViewModel : ViewModel() {

    var lst = MutableLiveData<ArrayList<CharacterResponseDTO>>()
}