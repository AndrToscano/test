package com.toscano.test.core

import android.app.Application
import com.toscano.test.data.repository.DBConnection
import com.toscano.test.data.repository.DBRepository
import com.toscano.test.logic.login.SignIn

class Test : Application() {

    //var con : DBConnection? = null
    override fun onCreate() {
        super.onCreate()
        /*
        con = DBConnection().getConnection(applicationContext)
        SignIn(con).insertUsers()
         */
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    //Acceder a cualquier momento sin instanciar
    //Es un Objeto dentro de una Clase
    companion object{
        private lateinit var con : DBRepository

        fun getConnectionDB(): DBRepository? {
            return con
        }
    }

}