package com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasource

import com.aldikitta.mvvmsimplemovieapp.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}