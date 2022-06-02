package com.aldikitta.mvvmsimplemovieapp.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aldikitta.mvvmsimplemovieapp.domain.movie.GetMoviesUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.movie.UpdateMovieUseCase

class MovieViewModelFactory(
    private val getMovieUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUseCase, updateMovieUseCase) as T
    }

}