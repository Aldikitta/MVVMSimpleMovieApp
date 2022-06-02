package com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasourceimplement

import com.aldikitta.mvvmsimplemovieapp.data.db.ArtistDao
import com.aldikitta.mvvmsimplemovieapp.data.db.TvShowDao
import com.aldikitta.mvvmsimplemovieapp.data.model.tvShow.TvShow
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImplement(
    private val tvshowDao: TvShowDao
) : TvShowLocalDataSource {

    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvshowDao.getTvShows()

    }

    override suspend fun saveTvShowsToDB(tvshows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDao.saveTvShows(tvshows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDao.deleteAllTvShows()
        }
    }
}