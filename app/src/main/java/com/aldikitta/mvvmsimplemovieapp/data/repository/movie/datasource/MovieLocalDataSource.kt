package com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasource

import com.aldikitta.mvvmsimplemovieapp.data.model.movie.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}