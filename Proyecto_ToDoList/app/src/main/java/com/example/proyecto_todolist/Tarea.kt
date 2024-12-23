package com.example.proyecto_todolist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tareas")
class Tarea{
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
    @ColumnInfo(name = "titulo")
    var titulo: String = ""
    @ColumnInfo(name = "estaCompletada")
    var estaCompletada: Boolean = false
    @ColumnInfo(name = "apartado")
    var apartado: String = ""
    @ColumnInfo(name = "tiempo")
    var tiempo: String = ""

    constructor(titulo: String, apartado: String, tiempo: String){
        this.titulo = titulo
        this.apartado = apartado
        this.tiempo = tiempo
    }
}