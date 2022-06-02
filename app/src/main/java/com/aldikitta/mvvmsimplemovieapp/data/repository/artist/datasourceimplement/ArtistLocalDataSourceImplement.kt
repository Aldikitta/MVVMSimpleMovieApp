package com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasourceimplement

import com.aldikitta.mvvmsimplemovieapp.data.db.ArtistDao
import com.aldikitta.mvvmsimplemovieapp.data.model.artist.Artist
import com.aldikitta.mvvmsimplemovieapp.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImplement(
    private val artistDao: ArtistDao

) : ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}