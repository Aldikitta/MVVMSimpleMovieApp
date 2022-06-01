package com.aldikitta.mvvmsimplemovieapp.domain.movie

import com.aldikitta.mvvmsimplemovieapp.data.model.movie.Movie

class UpdateMovieUseCase(
    private val movieRepository: MovieRepository
) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()

}