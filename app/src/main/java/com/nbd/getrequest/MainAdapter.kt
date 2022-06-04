package com.nbd.getrequest

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nbd.getrequest.databinding.ActivityMainBinding
import com.nbd.getrequest.databinding.ItemPokemonBinding
import org.json.JSONObject

class MainAdapter(private val pokes:Array<JSONObject>):RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(pokes[position])
    }

    override fun getItemCount(): Int=pokes.size

    class  MainHolder(val binding: ItemPokemonBinding):RecyclerView.ViewHolder(binding.root){
        fun render(poke:JSONObject){

        }
    }
}