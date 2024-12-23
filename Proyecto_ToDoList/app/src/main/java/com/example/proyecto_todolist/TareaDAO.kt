package com.example.proyecto_todolist

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
abstract class TareaDAO {
    @Query("SELECT * FROM tareas")
    abstract fun listaTareas():List<Tarea>

    @Insert
    abstract fun insertarTarea(task : Tarea)

    @Delete
    abstract fun eliminarTarea(task : Tarea)

    @Update
    abstract fun actualizarTarea(task : Tarea)
}