package com.toscano.test.logic.login.jikan

import android.util.Log
import com.toscano.test.core.getFullInfoAnimeLG
import com.toscano.test.data.network.endpoints.AnimeEndPoint
import com.toscano.test.data.network.repository.RetrofitBase
import com.toscano.test.logic.entities.FullInfoAnimeLG
import com.toscano.test.ui.core.Constants

class JikanAnimeUserCase {

    operator fun invoke(nameAnime : Int): FullInfoAnimeLG {


        val baseService = RetrofitBase.getRetrofitJikanConncetion()

        val service  = baseService.create(AnimeEndPoint::class.java)

        val callService = service.getAnimeFullInfo(nameAnime)

        var infoAnime = FullInfoAnimeLG()

        if (callService.isSuccessful){

            val a = callService.body()!!
            infoAnime = a.getFullInfoAnimeLG()

        }
        else{
            Log.d(Constants.TAG, "Error al llamado de la API de Jikan")
        }

        return infoAnime
    }
    /*
    fun getAllTopsAnimes(){
        return "Listados de Animes"
    }
     */

}