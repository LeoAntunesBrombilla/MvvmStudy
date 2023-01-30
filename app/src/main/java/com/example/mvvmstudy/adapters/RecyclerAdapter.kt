package com.example.mvvmstudy.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmstudy.R
import com.example.mvvmstudy.data.remote.characterDTO.CharacterDTO
import com.example.mvvmstudy.data.remote.characterDTO.CharacterResponseDTO

class RecyclerAdapter(private val characters: LiveData<List<CharacterResponseDTO>>) :
    RecyclerView.Adapter<RecyclerAdapter.CharacterViewHolder>() {


    private val characterList = mutableListOf<CharacterResponseDTO>()

    init {
        characters.observeForever {
            characterList.clear()
            characterList.addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.CharacterViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        val binding = inflater.inflate(R.layout.character, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.CharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    inner class CharacterViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        fun bind(characterResponse: CharacterResponseDTO) {
            val characters = characterResponse.results
            for (character in characters) {
                val name = character.name
                binding.findViewById<TextView>(R.id.characterName).text = name
            }
        }
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

}