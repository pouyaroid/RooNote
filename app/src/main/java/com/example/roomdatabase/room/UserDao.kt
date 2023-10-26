package com.example.roomdatabase.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(user: User)
    @Query("SELECT * FROM Table_person")
    suspend fun getAllUser():List<User>
   @Update
    suspend fun updateUssr(user: User)
   @Delete
   suspend fun deleteUser(user: User)
}