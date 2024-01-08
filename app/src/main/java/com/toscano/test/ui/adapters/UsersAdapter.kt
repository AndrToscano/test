package com.toscano.test.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.toscano.test.R
import com.toscano.test.data.local.entities.Users
import com.toscano.test.databinding.UserLayoutItemsBinding

class UsersAdapter ( private val listUsers: List<Users>) : RecyclerView.Adapter<UsersAdapter.ViewHolderUsers>() {

    //Creamos una CLase ViewHolder
    class ViewHolderUsers(view: View) : RecyclerView.ViewHolder(view){

        //esta variable no necesita un lateinit para ser inicializda.
        private var binding: UserLayoutItemsBinding = UserLayoutItemsBinding.bind(view)

        //Encargada de la iteracion de cada usuario
        fun render (item: Users) {

            //Ingreso de datos que se implementaran en la Interfaz
            binding.imageView.load("https://www.iconpacks.net/icons/2/free-user-icon-3297-thumb.png"){
                placeholder(R.drawable.avatar)
                crossfade(true)
            }
            binding.txtId.text = item.userId.toString()
            binding.txtName.text = item.firstName.toString()
            binding.txtLastName.text = item.lastName.toString()
        }
    }

    //Implementacion de la Clases Abstractas
    //Encargada de crear el Holder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUsers {

        //Encargado del inflado de la informacion
        val inflater = LayoutInflater.from(parent.context)

        //Se tiene el control del UsersItems
        return ViewHolderUsers(inflater.inflate(R.layout.user_layout_items, parent,false))
    }

    //Se encarga de gestionar el numero de datos exsiten y ver cuantas posiciones tiene.
    //Funcion {}
    /*
    override fun getItemCount(): Int {

        return listUsers.size
    }
    */
    //Funcion Lineal
    override fun getItemCount(): Int = listUsers.size


    //Ingresa cada uno de los elemoentos de las dos clases anteriores, los une y los envia.
    override fun onBindViewHolder(holder: ViewHolderUsers, position: Int) {

        holder.render(listUsers[position])
    }

}