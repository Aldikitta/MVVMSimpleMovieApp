package com.aldikitta.mvvmsimplemovieapp.data.repository.tvshow.datasource

import com.aldikitta.mvvmsimplemovieapp.data.model.tvShow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>

}