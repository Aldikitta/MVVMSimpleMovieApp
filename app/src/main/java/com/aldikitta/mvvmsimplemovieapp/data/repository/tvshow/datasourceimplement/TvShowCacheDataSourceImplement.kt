package com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasourceimplement

import com.aldikitta.mvvmsimplemovieapp.data.model.artist.Artist
import com.aldikitta.mvvmsimplemovieapp.data.model.tvShow.TvShow
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImplement: TvShowCacheDataSource {
    private var tvshowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvshowList
    }

    override suspend fun saveTvShowsToCache(tvshows: List<TvShow>) {
        tvshowList.clear()
        tvshowList = ArrayList(tvshows)
    }
}