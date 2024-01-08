package com.toscano.test.core

import android.app.Application
import com.toscano.test.data.local.repository.DBConnection
import com.toscano.test.data.local.repository.DBRepository
import com.toscano.test.logic.login.local.SignIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Test : Application() {

    //var con : DBConnection? = null
    override fun onCreate() {
        super.onCreate()

        //Realizacion de Corrutinas

        //1. Creacion de un ambiente
        //2. dsipatchers
        //3. La funcion launch
        con = DBConnection().getConnection(applicationContext)

        GlobalScope.launch(Dispatchers.IO){

            SignIn(con).insertUsers()
        }
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