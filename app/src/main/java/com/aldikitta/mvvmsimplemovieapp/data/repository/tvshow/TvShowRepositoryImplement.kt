package com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow

import android.util.Log
import com.aldikitta.mvvmsimplemovieapp.data.model.tvShow.TvShow
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.aldikitta.mvvmsimplemovieapp.domain.tvshow.TvShowRepository

class TvShowRepositoryImplement(
    private val tvshowRemoteDataSource: TvShowRemoteDataSource,
    private val tvshowLocalDataSource: TvShowLocalDataSource,
    private val tvshowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()

    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvshowLocalDataSource.clearAll()
        tvshowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvshowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvshowList: List<TvShow>

        try {
            val response = tvshowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvshowList = body.tvShows
            }
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        return tvshowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvshowList: List<TvShow>

        try {
            tvshowList = tvshowLocalDataSource.getTvShowsFromDB()
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        if (tvshowList.size > 0) {
            return tvshowList
        } else {
            tvshowList = getTvShowsFromAPI()
            tvshowLocalDataSource.saveTvShowsToDB(tvshowList)
        }
        return tvshowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvshowList: List<TvShow>

        try {
            tvshowList = tvshowCacheDataSource.getTvShowsFromCache()
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }
        if (tvshowList.size > 0) {
            return tvshowList
        } else {
            tvshowList = getTvShowsFromDB()
            tvshowCacheDataSource.saveTvShowsToCache(tvshowList)
        }
        return tvshowList
    }
}