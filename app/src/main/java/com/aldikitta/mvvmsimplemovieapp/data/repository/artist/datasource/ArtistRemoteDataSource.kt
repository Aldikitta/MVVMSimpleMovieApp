package com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasource

import com.aldikitta.mvvmsimplemovieapp.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>

}