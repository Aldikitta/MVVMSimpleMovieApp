package com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasourceimplement

import com.aldikitta.mvvmsimplemovieapp.data.model.artist.Artist
import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImplement : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}