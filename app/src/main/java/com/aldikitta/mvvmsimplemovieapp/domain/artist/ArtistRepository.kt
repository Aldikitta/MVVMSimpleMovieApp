package com.aldikitta.mvvmsimplemovieapp.domain.artist

import com.aldikitta.mvvmsimplemovieapp.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists():List<Artist>?
}