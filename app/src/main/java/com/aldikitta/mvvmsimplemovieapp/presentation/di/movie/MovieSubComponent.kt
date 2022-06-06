package com.aldikitta.mvvmsimplemovieapp.presentation.di.movie

import com.aldikitta.mvvmsimplemovieapp.presentation.artist.ArtistActivity
import com.aldikitta.mvvmsimplemovieapp.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}