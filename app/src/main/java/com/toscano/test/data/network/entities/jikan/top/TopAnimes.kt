package com.toscano.test.data.network.entities.jikan.top

data class TopAnimes(
    val `data`: List<Data> = listOf(),
    val pagination: Pagination? = null
)