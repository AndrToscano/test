package com.toscano.test.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.toscano.test.core.Test
import com.toscano.test.databinding.LoginActivity2Binding
import com.toscano.test.logic.login.local.SignIn
import com.toscano.test.ui.core.Constants

class LoginActivity2 : AppCompatActivity() {

    private lateinit var binding: LoginActivity2Binding
    private val signIn : SignIn = SignIn(Test.getConnectionDB()!!)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Binding
        binding = LoginActivity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        //initControls()
        initListeners()

    }

    //1era Forma
    /*
private fun initControls(){

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
            //val intentExp = Intent(this,MainActivity::class.java)
            //intentExp.putExtra(Constants.TEXT_VARIABLE_1, "Mi primera Chamba")
            //startActivity(intentExp)
            Snackbar.make(binding.btnLogin, "Bienvenido", Snackbar.LENGTH_LONG).show()
        }
    }
}
     */

    private fun initListeners(){
        binding.btnLogin.setOnClickListener{

            val check = SignIn(Test.getConnectionDB()!!).checkUserAndPassword(
                binding.txtUsername.text.toString(),
                binding.txtPassword.text.toString()
            )
            if (check > 0)
            {
                val intent = Intent(this, PrincipalActivity::class.java)
                intent.putExtra(Constants.USER_ID,check)
                startActivity(intent)
            //Snackbar.make(binding.txtUsername, "Bienvenido", Snackbar.LENGTH_LONG).show()
            }

            else{
                Snackbar.make(binding.txtUsername, "Usuario o credenciales son incorrectos", Snackbar.LENGTH_LONG).show()
            }

        }
    }
    override fun onDestroy() {
        super.onDestroy()
    }

}