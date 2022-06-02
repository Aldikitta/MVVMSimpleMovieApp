package com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasourceimplement

import com.aldikitta.mvvmsimplemovieapp.data.api.TMDBService
import com.aldikitta.mvvmsimplemovieapp.data.model.artist.ArtistList
import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImplement(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apiKey)

    }
}