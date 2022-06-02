package com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource

import com.aldikitta.mvvmsimplemovieapp.data.model.tvShow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvshows: List<TvShow>)
}