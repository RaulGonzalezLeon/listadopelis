package com.example.listadopelis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadopelis.adapter.FilmAdapter
import com.example.listadopelis.databinding.ActivityMainBinding

class MainActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("Listapelis")
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val decoration = DividerItemDecoration(this, VERTICAL)
        val manager = LinearLayoutManager(this)
        var adapter = FilmAdapter(FilmProvider.filmList)
        binding.recycler.layoutManager = manager
        binding.recycler.adapter= adapter
        //binding.recycler.addItemDecoration(decoration)



        binding.filtro.addTextChangedListener {filtro ->
                val filtroPeli = FilmProvider.filmList.filter { film ->
                    film.title.lowercase().contains(filtro.toString().lowercase())  }
                adapter.actualizarPeliculas(filtroPeli)
            }




    }
}