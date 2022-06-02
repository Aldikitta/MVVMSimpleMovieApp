package com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource

import com.aldikitta.mvvmsimplemovieapp.data.model.tvShow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(tvshows: List<TvShow>)
    suspend fun clearAll()
}