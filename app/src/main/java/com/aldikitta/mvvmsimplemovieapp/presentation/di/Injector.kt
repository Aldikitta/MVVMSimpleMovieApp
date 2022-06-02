package com.aldikitta.mvvmsimplemovieapp.presentation.di

import com.aldikitta.mvvmsimplemovieapp.presentation.di.artist.ArtistSubComponent
import com.aldikitta.mvvmsimplemovieapp.presentation.di.movie.MovieSubComponent
import com.aldikitta.mvvmsimplemovieapp.presentation.di.tvshow.TvShowSubComponent
import dagger.Module

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent

    fun createTvShowSubComponent(): TvShowSubComponent

    fun createArtistSubComponent(): ArtistSubComponent
}