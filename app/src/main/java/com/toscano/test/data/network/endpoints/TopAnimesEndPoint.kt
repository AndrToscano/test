package com.toscano.test.data.network.endpoints

import com.toscano.test.data.network.entities.jikan.top.TopAnimes
import retrofit2.Response
import retrofit2.http.GET

interface TopAnimesEndPoint {
    @GET("top/anime")
    fun getAllTopAnimes() : Response<List<TopAnimes>>
}