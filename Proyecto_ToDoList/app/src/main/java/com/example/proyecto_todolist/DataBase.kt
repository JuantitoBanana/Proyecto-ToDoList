package com.example.proyecto_todolist

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Tarea ::class], version = 1)
abstract class DataBase:RoomDatabase() {
    abstract fun tareaDao() : TareaDAO
}