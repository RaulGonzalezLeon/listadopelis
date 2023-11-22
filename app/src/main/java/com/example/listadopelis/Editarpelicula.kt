package com.example.listadopelis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadopelis.adapter.FilmAdapter
import com.example.listadopelis.databinding.ActivityEditarpeliculaBinding

class Editarpelicula : ActivityWithMenus() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEditarpeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}