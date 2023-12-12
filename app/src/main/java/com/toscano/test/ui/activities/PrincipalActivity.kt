package com.toscano.test.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.toscano.test.R
import com.toscano.test.core.Test
import com.toscano.test.databinding.ActivityMainBinding
import com.toscano.test.databinding.ActivityPrincipalBinding
import com.toscano.test.logic.login.SignIn
import com.toscano.test.ui.activities.fragments.FavoritesFragment
import com.toscano.test.ui.activities.fragments.ListFragment
import com.toscano.test.ui.core.Constants
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
                else -> {
                    //Ambiente en el que el Activity cumple un ciclo de vida
                    //Visualizara los datos del Usuario
                    lifecycleScope.launch(Dispatchers.Main) {

                        //Generara cambios en la Base de Datos
                        val name = withContext(Dispatchers.IO){

                            val a = "Juan"
                            val b = a + " Toscano"
                            b//Se devolvera lo unico que se toma
                        }

                        // Ejecucion de las corrtuinas - Se ejecutan a la vez
                        val listC = listOf<Deferred<String>>(
                            async {getName()},
                            async {getName()},
                            async {getName()}
                        )



                        //Se recoge las diferetes corrutinas a ejecucion
                        //val w = awaitAll(listaC)

                        //Generara cambios en la Base de Datos
                        val name1 = withContext(Dispatchers.IO){

                            getName()
                        }
                        binding.txtUser.text = name.toString()
                    }
                    false
                }
            }
        }
    }

    suspend fun getName () :String{
        val a = "Juan"
        val b = a + " Toscano"
        return b
    }
}