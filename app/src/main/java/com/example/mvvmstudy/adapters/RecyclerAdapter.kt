package com.example.mvvmstudy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmstudy.R
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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character , parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.CharacterViewHolder, position: Int) {
        val character = characterList[position]
        holder.bind(character)
    }

    inner class CharacterViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        fun bind(character: CharacterResponseDTO) {
            binding.findViewById<TextView>(R.id.characterName).text = character.name
        }
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

}