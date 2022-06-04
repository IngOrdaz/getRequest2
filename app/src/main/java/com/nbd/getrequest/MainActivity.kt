package com.nbd.getrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.nbd.getrequest.databinding.ActivityMainBinding
import com.nbd.getrequest.databinding.ActivityMainBinding.inflate
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var  queue:RequestQueue
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //en activity this en fragment context
        queue=Volley.newRequestQueue(this )
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnUpdatePokemon.setOnClickListener{
            var numberList=binding.etPokemonAmount.text.toString().toInt()
            getPokemonList(numberList)
        }


    }
    fun getPokemonList(listAmount: Int) {
        val url="https://pokeapi.co/api/v2/pokemon/?limit=${listAmount}"

        val jsonRequest= JsonObjectRequest(url , Response.Listener<JSONObject> {
            response ->
            Log.i("JSONRESPONSE", response.getJSONArray("results").toString())


        },
        Response.ErrorListener { error ->
         Log.w("JSONRESPONSE", error.message as String)
        })

        queue.add(jsonRequest)
    }

    override fun onStop() {
        super.onStop()
        queue.cancelAll("Stopped")
    }
}