package com.toscano.test.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.toscano.test.R
import com.toscano.test.core.Test
import com.toscano.test.databinding.ActivityMainBinding
import com.toscano.test.databinding.ActivityPrincipalBinding
import com.toscano.test.logic.login.SignIn
import com.toscano.test.ui.core.Constants

class PrincipalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras.let {

            //Clase
            /*
            Test().con
             */

            //Objeto
            /*
            Test.con
             */

            //1era Forma - Objeto
            Test.getConnectionDB()!!.getUsersDAO().getOneUser(1)

            val userID = it?.getInt(Constants.USER_ID)

            if (userID != null ) {

                val user = SignIn(Test.getConnectionDB()!!).getUserName(userID)
                binding.txtUser.text = user.firstName.toString()
            }
            else{
                Snackbar.make(binding.txtUser,"Ocurrio un error",Snackbar.LENGTH_LONG).show()
            }
        }
    }
}