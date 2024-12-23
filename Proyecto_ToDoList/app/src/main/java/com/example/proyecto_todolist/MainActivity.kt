package com.example.proyecto_todolist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tarea1 = Tarea("Hacer la compra","Casa","Mañana")
        val tarea2 = Tarea("Pasear al perro","Calle","Hoy")
        val tarea3 = Tarea("Hacer la colada","Casa","Hoy")

        var listaTareas = mutableListOf(tarea1, tarea2, tarea3)

        binding.rvListaTareas.adapter = AdaptadorTarea(listaTareas)
        binding.rvListaTareas.layoutManager = LinearLayoutManager(this)
    }
}