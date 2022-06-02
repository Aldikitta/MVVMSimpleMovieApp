package com.aldikitta.mvvmsimplemovieapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aldikitta.mvvmsimplemovieapp.domain.movie.GetMoviesUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.movie.UpdateMovieUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMovieUseCase
) : ViewModel() {
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}