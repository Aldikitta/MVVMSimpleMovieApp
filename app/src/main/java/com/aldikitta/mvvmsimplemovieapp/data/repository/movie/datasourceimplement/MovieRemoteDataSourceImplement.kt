package com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasourceimplement

import com.aldikitta.mvvmsimplemovieapp.data.api.TMDBService
import com.aldikitta.mvvmsimplemovieapp.data.model.movie.MovieList
import com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImplement(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}