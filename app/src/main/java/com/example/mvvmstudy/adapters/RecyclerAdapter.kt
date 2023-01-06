package com.example.mvvmstudy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmstudy.R
import com.example.mvvmstudy.data.remote.characterDTO.CharacterResponseDTO
import com.example.mvvmstudy.viewModels.MainViewModel

class RecyclerAdapter (val viewModel: MainViewModel, val list: ArrayList<CharacterResponseDTO>, val context: Context):
    RecyclerView.Adapter<RecyclerAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.CharacterViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.character, parent, false)
        return CharacterViewHolder(root)
    }

    override fun getItemCount(): Int {
        if(list.size == 0) {
            Toast.makeText(context, "Sem Personagens", Toast.LENGTH_LONG).show()
        }
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.CharacterViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    inner class CharacterViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        fun bind(character: CharacterResponseDTO) {
            binding.findViewById<TextView>(R.id.characterName).text = character.name
        }
    }


}