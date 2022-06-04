package com.nbd.getrequest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nbd.getrequest.databinding.ActivityMainBinding
import com.nbd.getrequest.databinding.ItemPokemonBinding
import org.json.JSONArray
import org.json.JSONObject

class MainAdapter(private val pokes: JSONArray):RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding=ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(pokes.getJSONObject(position))
    }

    override fun getItemCount(): Int = pokes.length()

    class  MainHolder(val binding: ItemPokemonBinding):RecyclerView.ViewHolder(binding.root){
        fun render(poke:JSONObject){
            binding.tvName.setText(poke.getString("name"))
            binding.tvUrl.setText((poke.getString("url")))
        }
    }
}
