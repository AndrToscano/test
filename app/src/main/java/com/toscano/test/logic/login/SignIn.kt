package com.toscano.test.logic.login

import android.adservices.adid.AdId
import android.util.Log
import com.toscano.test.data.entities.Users
import com.toscano.test.data.repository.DBUsers
import com.toscano.test.ui.core.Constants

class SignIn {

    fun checkUserAndPassword(username: String, password: String): Int{

        val users = DBUsers().getListUsers()
        //Integer
        var ret = -1

        val listUsers = users.filter {
            it.password == password && it.userName == username
        }

        if (listUsers.isNotEmpty()){
            ret = listUsers.first().userId
        }
        return ret

        //Booleanos
        //Log.d(Constants.TAG,listUsers.first().userId.toString())

        //return listUsers.isNotEmpty()

        //return users.contains(Users(username, password))
    }

    fun getUserName(userId: Int) : Users{

        return DBUsers().getListUsers().first{ it.userId == userId }
    }
}