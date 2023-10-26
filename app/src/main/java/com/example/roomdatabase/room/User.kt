package com.example.roomdatabase.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Table_person")
data class User(
    @PrimaryKey
    val fitstName: String,
    val lastName: String
)
