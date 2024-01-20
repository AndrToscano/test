package com.toscano.test.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.toscano.test.R
import com.toscano.test.data.local.entities.Users
import com.toscano.test.data.network.entities.jikan.top.Data
import com.toscano.test.data.network.entities.jikan.top.TopAnimes
import com.toscano.test.databinding.AnimeLayoutItemsBinding
import com.toscano.test.databinding.UserLayoutItemsBinding

class AnimeAdapter (private val listUsers: List<Data>) : RecyclerView.Adapter<AnimeAdapter.ViewHolderAnime>() {

    //Creamos una CLase ViewHolder
    class ViewHolderAnime(view: View) : RecyclerView.ViewHolder(view){

        //esta variable no necesita un lateinit para ser inicializda.
        private var binding: AnimeLayoutItemsBinding = AnimeLayoutItemsBinding.bind(view)

        //Encargada de la iteracion de cada usuario
        fun render (item: Data) {
            binding.imageView.load(item.images.jpg.large_image_url)
            binding.txtId.text = item.title_english
            binding.txtName.text = item.synopsis

        }
    }

    //Implementacion de la Clases Abstractas
    //Encargada de crear el Holder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAnime {

        //Encargado del inflado de la informacion
        val inflater = LayoutInflater.from(parent.context)

        //Se tiene el control del UsersItems
        return ViewHolderAnime(inflater.inflate(R.layout.anime_layout_items, parent,false))
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
    override fun onBindViewHolder(holder: ViewHolderAnime, position: Int) {

        holder.render(listUsers[position])
    }

}