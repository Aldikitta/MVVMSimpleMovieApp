package com.aldikitta.mvvmsimplemovieapp.presentation.di.movie

import com.aldikitta.mvvmsimplemovieapp.domain.movie.GetMoviesUseCase
import com.aldikitta.mvvmsimplemovieapp.domain.movie.UpdateMovieUseCase
import com.aldikitta.mvvmsimplemovieapp.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMovieUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}