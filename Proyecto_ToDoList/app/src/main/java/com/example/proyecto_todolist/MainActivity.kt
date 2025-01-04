package com.example.proyecto_todolist

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.proyecto_todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    lateinit var listaTareas : MutableList<Tarea>
    lateinit var adaptador : AdaptadorTarea


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Inicio"
        var basedatos: DataBase = Room.databaseBuilder(this, DataBase::class.java, "BDTareas").allowMainThreadQueries().build()
        var tareaDAO: TareaDAO = basedatos.tareaDao()

        val launchSecondActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val nuevaTarea = Tarea(result.data?.getStringExtra("tareaNombre")!!, result.data?.getStringExtra("tareaApartado")!!, result.data?.getStringExtra("tareaTiempo")!!)
                tareaDAO.insertarTarea(nuevaTarea)
                listaTareas.add(nuevaTarea)
                binding.rvListaTareas.adapter?.notifyItemInserted(listaTareas.size-1)
            }
        }

        
        listaTareas = tareaDAO.listaTareas()

        adaptador = AdaptadorTarea(listaTareas){ position: Int ->
            tareaDAO.eliminarTarea(listaTareas.get(position))
            listaTareas.removeAt(position)
            adaptador.notifyItemRemoved(position)
            adaptador.notifyItemRangeChanged(position, listaTareas.size)
        }

        binding.rvListaTareas.adapter = adaptador
        binding.rvListaTareas.layoutManager = LinearLayoutManager(this)

        binding.bAniadirTarea.setOnClickListener(){
            val intent = Intent(this, ActivityCrearTarea::class.java)
            launchSecondActivity.launch(intent)

        }
    }
}