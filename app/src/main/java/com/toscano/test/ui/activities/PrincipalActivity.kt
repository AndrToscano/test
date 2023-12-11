package com.toscano.test.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.toscano.test.R
import com.toscano.test.core.Test
import com.toscano.test.databinding.ActivityMainBinding
import com.toscano.test.databinding.ActivityPrincipalBinding
import com.toscano.test.logic.login.SignIn
import com.toscano.test.ui.activities.fragments.FavoritesFragment
import com.toscano.test.ui.activities.fragments.ListFragment
import com.toscano.test.ui.core.Constants

class PrincipalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
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
        */

        //1. Instanciar el Fragment
        val listFragment = ListFragment()
        val favoritesFragment = FavoritesFragment()

        /*
        //2. Instanciar un Transaction
        val transaction = supportFragmentManager.beginTransaction()


        //3. Reemplazar con la variable Fragment
        transaction.replace(binding.frameContainer.id, listFragment)
        //transaction.replace(binding.frameContainer1.id, favoritesFragment)

        //4. Commit
        transaction.commit()
         */

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.item_list -> {
                    // Respond to navigation item 1 click
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(binding.frameContainer.id, listFragment)
                    transaction.commit()
                    true
                }
                R.id.item_fav -> {
                    // Respond to navigation item 2 click
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(binding.frameContainer.id, favoritesFragment)
                    transaction.commit()
                    true
                }
                else -> false
            }
        }
    }
}