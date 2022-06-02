package com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasourceimplement

import com.aldikitta.mvvmsimplemovieapp.data.api.TMDBService
import com.aldikitta.mvvmsimplemovieapp.data.model.tvShow.TvShowList
import com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImplement(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)

    }
}