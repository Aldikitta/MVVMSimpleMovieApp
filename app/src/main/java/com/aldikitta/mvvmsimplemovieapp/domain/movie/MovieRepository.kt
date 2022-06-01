package com.aldikitta.mvvmsimplemovieapp.domain.movie

import com.aldikitta.mvvmsimplemovieapp.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}