package com.toscano.test.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.toscano.test.R
import com.toscano.test.core.Test
import com.toscano.test.data.local.entities.Users
import com.toscano.test.databinding.ActivityPrincipalBinding
import com.toscano.test.logic.login.local.SignIn
import com.toscano.test.ui.activities.fragments.FavoritesFragment
import com.toscano.test.ui.activities.fragments.ListFragment
import com.toscano.test.ui.adapters.UsersAdapter
import com.toscano.test.ui.core.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PrincipalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        correr()
        initFragments()

        //Llama a la Base de Datos
        checkDataBase()

        initRecyclerView()

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


    }

    private fun initFragments(){

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

            //variable Manager
            val manager = supportFragmentManager

            when(item.itemId) {
                R.id.item_list -> {
                    // Respond to navigation item 1 click
                    val transaction = manager.beginTransaction()
                    transaction.replace(binding.frameContainer.id, listFragment)
                    transaction.commit()
                    true
                }
                R.id.item_fav -> {
                    // Respond to navigation item 2 click
                    val transaction = manager.beginTransaction()
                    transaction.replace(binding.frameContainer.id, favoritesFragment)
                    transaction.commit()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun correr(){
        //Ambiente en el que el Activity cumple un ciclo de vida
        //Visualizara los datos del Usuario
        lifecycleScope.launch(Dispatchers.Main) {

            //Generara cambios en la Base de Datos
            val name = withContext(Dispatchers.IO){

                val a = "Juan"
                val b = a + " Toscano"
                b//Se devolvera lo unico que se toma

            }

            val w = withContext(Dispatchers.Default){

                // Ejecucion de las corrtuinas - Se ejecutan a la vez
                val listC = listOf(
                    async {getName()},
                    async {getName()},
                    async {getName()}
                )

                //Se recoge las diferetes corrutinas a ejecucion
                val w1 = listC.awaitAll()
            }



            //Generara cambios en la Base de Datos
            val name1 = withContext(Dispatchers.IO){

                getName()
            }
            binding.txtUser.text = name1
        }
    }

    private fun checkDataBase(){

        /*
        //Del Main a un hilo secundario
        lifecycleScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO){
                //Se crea una instancia, se inyecta la dependencia y llama a los usuarios
                val usrs =SignIn(Test.getConnectionDB()!!).getAllUsers()
            }
        }
         */

        /*
        // Base de Datos - Nueva modificacion
        lifecycleScope.launch(Dispatchers.Main) {
            val usrs = withContext(Dispatchers.IO){
                getUsersList()
            }
            Log.d(Constants.TAG, usrs.toString())
        }
         */


        // De un hilo secuandario al Main
        lifecycleScope.launch(Dispatchers.IO) {
            val usrs = SignIn(Test.getConnectionDB()!!).getAllUsers()

            withContext(Dispatchers.Main){
                usrs
            }
            Log.d(Constants.TAG, usrs.toString())
        }

    }
    suspend fun getName () :String{
        val a = "Juan"
        val b = a + " Toscano"
        return b
    }

    private fun initRecyclerView(){

        lifecycleScope.launch(Dispatchers.Main) {
            binding.animationView.visibility = View.VISIBLE
            val usrs = withContext(Dispatchers.IO){
                getUsersList()
            }
            //Instanciar el adapter
            val adapter : UsersAdapter = UsersAdapter(usrs)
            binding.rvUsers.adapter = adapter
            binding.rvUsers.layoutManager = LinearLayoutManager(this@PrincipalActivity, LinearLayoutManager.VERTICAL, false)
            binding.animationView.visibility = View.GONE
        }
    }

    //Consulta sin Corrutinas
    suspend private fun getUsersList() : List<Users>{

        //Retardo para Carga
        delay(7000)
        return SignIn(Test.getConnectionDB()!!).getAllUsers()
    }
}