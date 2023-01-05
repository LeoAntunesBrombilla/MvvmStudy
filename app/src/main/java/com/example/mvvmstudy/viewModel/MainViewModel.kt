package com.example.mvvmstudy.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmstudy.model.Character

class MainViewModel : ViewModel() {

    var lst = MutableLiveData<ArrayList<Character>>()
}