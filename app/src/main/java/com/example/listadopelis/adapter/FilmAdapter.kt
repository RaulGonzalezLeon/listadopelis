package com.example.listadopelis.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listadopelis.Film
import com.example.listadopelis.R

class FilmAdapter (private var filmList:List<Film>): RecyclerView.Adapter<FilmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return FilmViewHolder(layoutInflater.inflate(R.layout.item_film,parent,false))
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val item = filmList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = filmList.size

    fun actualizarPeliculas(listapeliculas: List<Film>) {
        this.filmList = listapeliculas
        notifyDataSetChanged()
    }
}