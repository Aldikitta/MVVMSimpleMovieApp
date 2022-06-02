package com.aldikitta.mvvmsimplemovieapp.data.repository.artist

import android.util.Log
import com.aldikitta.mvvmsimplemovieapp.data.model.artist.Artist
import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.aldikitta.mvvmsimplemovieapp.domain.artist.ArtistRepository

class ArtistRepositoryImplement(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistlList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistlList = body.artists
            }
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        return artistlList
    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistlList: List<Artist>

        try {
            artistlList = artistLocalDataSource.getArtistsFromDB()
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        if (artistlList.size > 0) {
            return artistlList
        } else {
            artistlList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistlList)
        }
        return artistlList
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistlList: List<Artist>

        try {
            artistlList = artistCacheDataSource.getArtistsFromCache()
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        if (artistlList.size > 0) {
            return artistlList
        } else {
            artistlList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistlList)
        }
        return artistlList
    }
}