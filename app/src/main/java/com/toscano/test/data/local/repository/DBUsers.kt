package com.toscano.test.data.local.repository

import com.toscano.test.data.local.entities.Users

class DBUsers {

    fun getListUsers(): List<Users>{

        return listOf<Users>(
        Users("admin1", "admin1",1, "Juan","Toscano" ),
        Users("admin2", "admin2",2, "Andres","Lucero" ),
        Users("admin3", "admin3",3, "David","Fonseca")
        )
    }
}