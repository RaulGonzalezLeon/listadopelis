package com.example.listadopelis

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

open class ActivityWithMenus : AppCompatActivity() {
    companion object{
        var actividadActual = 0
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        var inflater: MenuInflater = menuInflater
            inflater.inflate(R.menu.menu_principal,menu)
        for (i in 0 until menu.size()){
            if (i == actividadActual) menu.getItem(i).isEnabled = false
            else menu.getItem(i).isEnabled = true
        }

        val itemBuscar = menu.findItem(R.id.Buscar)
        itemBuscar.isVisible = actividadActual == 0
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.Peliculas -> {
                val intent = Intent(this, MainActivity::class.java )
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                actividadActual = 0
                startActivity(intent)
                true
            }
            R.id.EditarPeliculas -> {
                val intent = Intent(this, Editarpelicula::class.java )
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                actividadActual = 1
                startActivity(intent)
                true
            }
            R.id.App -> {
                val intent = Intent(this, Info::class.java )
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                actividadActual = 2
                startActivity(intent)
                true
            }
            R.id.Salir -> {
                AlertDialog.Builder(this)
                    .setTitle("Confirmacion")
                    .setMessage("¿Desea salir de la aplicacion?")
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.ok, {dialog, which ->
                        Toast.makeText(applicationContext, "Ha salido de la aplicacion", Toast.LENGTH_SHORT).show()
                    })
                    .setNegativeButton(android.R.string.cancel, {dialog, which ->
                        Toast.makeText(applicationContext, "No ha salido de la aplicacion", Toast.LENGTH_SHORT).show()
                    })
                    .show()
                true
            }
            R.id.Buscar -> {

                val filtro = findViewById<EditText>(R.id.filtro)

                if (filtro.visibility == View.INVISIBLE){
                    filtro.visibility = View.VISIBLE
                }
                else{
                    filtro.visibility = View.INVISIBLE
                }

                 true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}