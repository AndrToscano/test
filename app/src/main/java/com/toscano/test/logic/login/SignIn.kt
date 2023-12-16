package com.toscano.test.logic.login

import android.adservices.adid.AdId
import android.content.Context
import android.util.Log
import com.toscano.test.data.entities.Users
import com.toscano.test.data.repository.DBConnection
import com.toscano.test.data.repository.DBRepository
import com.toscano.test.data.repository.DBUsers
import com.toscano.test.ui.core.Constants
import java.sql.Connection

class SignIn (val connection: DBRepository) {

    //Tipo Parametro
    /*
    var context: Context? = null

    lateinit var context1: Context

     */

    //Tipo Constructor
    /*
    fun initClass(context: Context){
        context1 = context
    }

     */

    fun checkUserAndPassword(username: String, password: String): Int {

        val users = DBUsers().getListUsers()
        //Integer
        var ret = -1

        val listUsers = users.filter {
            it.password == password && it.userName == username
        }

        if (listUsers.isNotEmpty()) {
            ret = listUsers.first().userId
        }
        return ret

        //Booleanos
        //Log.d(Constants.TAG,listUsers.first().userId.toString())

        //return listUsers.isNotEmpty()

        //return users.contains(Users(username, password))
    }

    //Funcion {}
    /*
    fun getUserName(userId: Int) : Users{

        return DBUsers().getListUsers().first{ it.userId == userId }
    }

     */

    //Funcion Lineal
    suspend fun getUserName(userId: Int): Users = DBUsers().getListUsers().first { it.userId == userId }

    //Funcion {}
    /*
    fun getUserName1 (userId: Int): Users{

        //1era Forma
        /*
        //Conexion a la Base de Datos
        val con = DBConnection().getConnection(context)
        val user = con.getUsersDAO().getOneUser(userId)

        return user
         */

        //2da Forma
        //Conexion a la Base de Datos
        //val connection = DBConnection().getConnection(context)
        return connection.getUsersDAO().getOneUser(userId)

    }
     */

    //Funcion Lineal
    fun getUserName1(userId: Int): Users = connection.getUsersDAO().getOneUser(userId)

    //Funcion {}
    /*
    fun insertUsers(){
        //1era Forma
        val user = DBUsers().getListUsers()
        connection.getUsersDAO().insertUsers(user)

        //2da Forma
        val user = connection.getUsersDAO().insertUsers(DBUsers().getListUsers())
    }
     */

    //Funcion Lineal
    suspend fun insertUsers() =
        if (connection.getUsersDAO().getAllUsers().isEmpty()) {
            connection.getUsersDAO().insertUsers(DBUsers().getListUsers())
        } else {
            null
        }

    //Funcion {}
    /*
    fun getAllUsers() : List<Users>{

        return connection.getUsersDAO().getAllUsers()
    }
     */

    //Funcion Lineal
    suspend fun getAllUsers(): List<Users> = connection.getUsersDAO().getAllUsers()

}