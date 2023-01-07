package com.example.mvvmstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmstudy.adapters.RecyclerAdapter
import com.example.mvvmstudy.data.remote.CharacterRepository
import com.example.mvvmstudy.data.remote.RetrofitClient
import com.example.mvvmstudy.data.remote.service.CharacterService
import com.example.mvvmstudy.viewModels.MainViewModel
import com.example.mvvmstudy.viewModels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: RecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitClient = RetrofitClient()

        val repository = CharacterRepository(retrofitClient)

        val service = CharacterService(repository)

        val factory = MainViewModelFactory(service)

        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        viewModel.loadCharacters()

        val listOfCharacters = findViewById<RecyclerView>(R.id.listOfCharacters)

        listOfCharacters.layoutManager = LinearLayoutManager(this)

        adapter = RecyclerAdapter(viewModel.characters)

        listOfCharacters.adapter = adapter


    }
}