package com.toscano.test.data.entities

import android.adservices.adid.AdId
import android.security.identity.AccessControlProfile
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(
                 var userName: String? = null,
                 var password: String? = null)

{
    @PrimaryKey(autoGenerate = true)
    var userId : Int = -1
    var firstName : String = "Usuario Desconocido"
    var lastName : String = "Usuario Desconocido"
    var profile : String = "Usuario Desconocido"

    constructor(userName: String?, password: String?, userId : Int)
            : this(userName, password)
            {
             this.userId = userId
            }
    constructor(id: Int,
                userName: String?,
                password: String?,
                profile: String): this(
                                       userName,
                                       password)
                {
                this.profile = profile
                }

    constructor(
                userName: String?,
                password: String?,
                userId: Int,
                firstName: String,
                lastName: String): this(
                                        userName,
                                        password)
                {
                this.userId = userId
                this.firstName = firstName
                this.lastName = lastName
                }
}
