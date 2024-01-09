package com.toscano.test.logic.login.jikan

import android.util.Log
import com.toscano.test.core.getFullInfoAnimeLG
import com.toscano.test.data.network.endpoints.AnimeEndPoint
import com.toscano.test.data.network.endpoints.TopAnimesEndPoint
import com.toscano.test.data.network.entities.jikan.top.TopAnimes
import com.toscano.test.data.network.repository.RetrofitBase
import com.toscano.test.logic.entities.FullInfoAnimeLG
import com.toscano.test.ui.core.Constants

class JikanGetTopAnimesUserCase {

    suspend fun getResponse(): TopAnimes {

        val result : Result<TopAnimes>
        var infoAnime = TopAnimes()

        try {
            val baseService = RetrofitBase.getRetrofitJikanConncetion()

            val service = baseService.create(TopAnimesEndPoint::class.java)

            val callService = service.getAllTopAnimes()


            if (callService.isSuccessful) {

                val a = callService.body()!!
                infoAnime = a
                result = Result.success(a)

            }

            else{
                Log.e(Constants.TAG, "Error al llamado de la API de Jikan")
            }
        }

        catch(ex: Exception) {
            Log.e(Constants.TAG, ex.stackTraceToString())
            //result = Result.failure()
        }

        return infoAnime
    }
}