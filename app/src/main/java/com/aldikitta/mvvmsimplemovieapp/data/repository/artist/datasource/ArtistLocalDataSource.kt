package com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasource

import com.aldikitta.mvvmsimplemovieapp.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearAll()
}