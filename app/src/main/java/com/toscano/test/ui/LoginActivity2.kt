package com.toscano.test.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.toscano.test.databinding.LoginActivity2Binding
import com.toscano.test.logic.login.SignIn
import com.toscano.test.ui.core.Constants

class LoginActivity2 : AppCompatActivity() {

    private lateinit var binding: LoginActivity2Binding
    private val signIn : SignIn = SignIn()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Binding
        binding = LoginActivity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        initControls()

    }

    fun initControls(){

        //Mensaje emergente
        binding.btnLogin.setOnClickListener {

            var usr = binding.txtUsername.text.toString()
            var psw = binding.txtPassword.text.toString()
            //Toast
            //Toast.makeText(this, u, Toast.LENGTH_LONG).show()
            signIn.checkUserAndPassword(usr, psw)

            if (!signIn.checkUserAndPassword(usr, psw))
                //SnackBar
                Snackbar.make(binding.btnLogin, "Usuario o credenciales son incorrectos", Snackbar.LENGTH_LONG).show()

            else{
                //Intent Implicito
                // val intentImp = Intent()
                // intentImp.action = Intent.ACTION_SEND
                // intentImp.putExtra(Intent.EXTRA_TEXT, "Mi primera chamba")
                // intentImp.type = "text/plain"
                // startActivity(intentImp)

                //Intent Explicito
                val intentExp = Intent(this,MainActivity::class.java)
                intentExp.putExtra(Constants.TEXT_VARIABLE_1, "Mi primera Chamba")
                startActivity(intentExp)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}