package com.example.listadopelis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listadopelis.databinding.ActivityEditarpeliculaBinding
import com.example.listadopelis.databinding.ActivityInfoBinding

class Info : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}