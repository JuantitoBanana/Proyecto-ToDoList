package com.example.proyecto_todolist

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_todolist.databinding.TareaBinding


class AdaptadorTarea(val tareas : MutableList<Tarea>, private val onItemDelete: (position: Int) -> Unit ) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    lateinit var binding: TareaBinding

    class TareaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = TareaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TareaViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return tareas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val tarea = tareas[position]
        binding.tarea = tarea
        binding.executePendingBindings()

        binding.cbTarea.setOnClickListener(){
            if(binding.cbTarea.isChecked){
                binding.tvTituloTarea.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                tarea.estaCompletada = true
            }else{
                binding.tvTituloTarea.paintFlags = binding.tvTituloTarea.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                tarea.estaCompletada = false
            }
        }

        binding.bBorrarTarea.setOnClickListener(){
            onItemDelete(position)
        }

    }
}