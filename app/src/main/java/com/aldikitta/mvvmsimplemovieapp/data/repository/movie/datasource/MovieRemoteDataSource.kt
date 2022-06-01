package com.aldikitta.mvvmsimplemovieapp.data.repository.movie.datasource

import com.aldikitta.mvvmsimplemovieapp.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}