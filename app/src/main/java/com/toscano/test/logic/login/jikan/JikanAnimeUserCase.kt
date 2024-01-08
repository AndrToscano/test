package com.toscano.test.logic.login.jikan

import android.util.Log
import com.toscano.test.data.network.endpoints.AnimeEndPoint
import com.toscano.test.data.network.endpoints.RetrofitBase
import com.toscano.test.logic.login.jikan.entities.FullInfoAnimeLG
import com.toscano.test.ui.core.Constants

class JikanAnimeUserCase {

    fun getFullAnimeInfo(nameAnime : Int): FullInfoAnimeLG{

        val baseService = RetrofitBase.getRetrofitJikanConncetion()

        val service  = baseService.create(AnimeEndPoint::class.java)

        val callService = service.getAnimeFullInfo(nameAnime)

        val infoAnime = FullInfoAnimeLG()

        if (callService.isSuccessful){

            infoAnime.id = callService.body()!!.data.mal_id
            infoAnime.name = callService.body()!!.data.title_english
            infoAnime.small_image = callService.body()!!.data.images.jpg.small_image_url
            infoAnime.big_image = callService.body()!!.data.images.jpg.large_image_url
        }
        else{
            Log.d(Constants.TAG, "Error al llamado de la API de Jikan")
        }

        return infoAnime
    }
}