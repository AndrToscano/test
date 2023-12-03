package com.toscano.test.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.toscano.test.data.entities.Users

@Dao
interface UsersDAO {
    @Query("select * from Users")
    fun getAllUsers() : List<Users>

    @Query("select * from Users where userId = :userId")
    fun getOneUser(userId: Int) : Users

    @Insert
    fun insertUsers(users: List<Users>)

    @Update
    fun updateUser(users: List<Users>)
}