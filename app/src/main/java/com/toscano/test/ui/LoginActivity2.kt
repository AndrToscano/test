package com.toscano.test.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.toscano.test.R
import com.toscano.test.databinding.LoginActivity2Binding

class LoginActivity2 : AppCompatActivity() {

    private lateinit var binding: LoginActivity2Binding
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

        binding.layoutLogin2Root.setOnClickListener{

        }
        //Mensaje emergente
        binding.btnLogin.setOnClickListener {

            var u = binding.txtUsername.text.toString()
            //Toast
            //Toast.makeText(this, u, Toast.LENGTH_LONG).show()
            //SnackBar
            Snackbar.make(binding.btnLogin, u, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}