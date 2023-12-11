package com.toscano.test.data.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.toscano.test.data.dao.UsersDAO
import com.toscano.test.data.entities.Users

@Database(entities = [Users::class], version = 1)

abstract class DBRepository : RoomDatabase() {
    abstract fun getUsersDAO() : UsersDAO

}

class DBConnection(){

    //Funcion {}
    /*
    fun getConnection(context: Context): DBRepository{

        //1era Forma - Sin DBRepository
        /*
        val con = Room.databaseBuilder(context, DBRepository::class.java, "DBTest").build()

        con.getUsersDAO().getAllUsers()

         */

        //2da Forma
        /*
        val con = Room.databaseBuilder(context, DBRepository::class.java, "DBTest").build()

        return con

         */

        //3era Forma
        /*
        return Room.databaseBuilder(context, DBRepository::class.java, "DBTest").build()

         */

    }
     */

    //Funcion en Linea

    fun getConnection(context: Context): DBRepository = Room.databaseBuilder(context, DBRepository::class.java, "DBTest").build()
}

