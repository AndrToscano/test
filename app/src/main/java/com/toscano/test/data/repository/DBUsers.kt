package com.toscano.test.data.repository

import com.toscano.test.data.entities.Users

class DBUsers {

    fun getListUsers(): List<Users>{

        var user1 = Users(1, "admin1", "admin1")
        var user2 = Users(2, "admin2", "admin2")
        var user3 = Users(3, "admin3", "admin3")

        var listUsers = listOf(user1, user2, user3)
        
        return listUsers
    }
}