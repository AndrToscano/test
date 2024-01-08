package com.toscano.test.core

import com.toscano.test.data.network.entities.jikan.anime.FullInfoAnime
import com.toscano.test.logic.entities.FullInfoAnimeLG

    fun FullInfoAnime.getFullInfoAnimeLG() = FullInfoAnimeLG (

        this.data.mal_id,
        this.data.title_english,
        this.data.images.jpg.small_image_url,
        this.data.images.jpg.large_image_url,
        this.data.synopsis
        )