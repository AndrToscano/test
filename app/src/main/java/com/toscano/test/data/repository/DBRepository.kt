package com.toscano.test.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.toscano.test.data.dao.UsersDAO
import com.toscano.test.data.entities.Users

@Database(entities = [Users::class], version = 1)
abstract class DBRepository : RoomDatabase() {
    abstract fun getUsersDAO() : UsersDAO

}